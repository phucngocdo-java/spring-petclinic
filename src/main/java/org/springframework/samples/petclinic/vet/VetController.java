// Done -  Đây là 1 controller - Thường viết trong folder controller trong package
/*
 * Copyright 2012-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vet;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class VetController {

	private final VetRepository vetRepository;

	public VetController(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	/**
	 * Done
	 * @param page: page lấy từ param url, không có param page thì page mặc định là 1
	 * @param model
	 * @return
	 */
	@GetMapping("/vets.html")
	public String showVetList(@RequestParam(defaultValue = "1") int page, Model model) {
		Vets vets = new Vets();
		Page<Vet> paginated = findPaginated(page);
		vets.getVetList().addAll(paginated.toList());

		log.info("Loaded126 vets size = {}, page = {}, totalElements = {}", vets.getVetList().size(), page,
				paginated.getTotalElements());

		return addPaginationModel(page, paginated, model);
	}

	private String addPaginationModel(int page, Page<Vet> paginated, Model model) {

		List<Vet> listVets = paginated.getContent();

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listVets", listVets);

		log.debug("Pagination added to model: page={}, size={}", page, listVets.size());

		return "vets/vetList";
	}

	private Page<Vet> findPaginated(int page) {

		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);

		log.debug("Fetching vets from DB: page={}, pageSize={}", page, pageSize);

		return vetRepository.findAll(pageable);
	}

	@GetMapping({ "/vets" })
	public @ResponseBody Vets showResourcesVetList() {

		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetRepository.findAll());

		log.info("REST API /vets returned size = {}", vets.getVetList().size());

		return vets;
	}

}
