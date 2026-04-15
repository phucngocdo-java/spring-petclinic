// Là 1 Wrapper(data container), thường đặt trong folder dto trong package
// Phân biệt giữa wrapper và DTO nhé:
//DTO = bản dữ liệu được “chọn lọc / biến đổi” từ entity (model)
//Wrapper = bọc nhiều object lại + thêm metadata
// File này giống wrapper nhiều hơn
//trong Spring Boot bạn hoàn toàn có thể gọi trực tiếp Entity trong controller, không bắt buộc phải có DTO hay Wrapper.

// Chứa danh sách các vet
//Wrapper/ DTO (Data Transfer Object) là một class dùng để truyền dữ liệu giữa các tầng trong ứng dụng,
// đặc biệt là giữa backend và client (frontend/API).
//Client
//	↓
//	Controller
//	↓
//	Service
//	↓
//	Repository
//	↓
//	Entity (DB data)
//	↓
//	DTO (map/transform data)
//	↓
//	Wrapper (optional)
//	↓
//	Response (JSON/XML)
//	↓
//	Frontend

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

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of veterinarians. Mostly here to be used for
 * the 'vets' {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Arjen Poutsma
 */
@XmlRootElement
public class Vets {

	private List<Vet> vets;

	@XmlElement
	public List<Vet> getVetList() {
		if (vets == null) {
			vets = new ArrayList<>();
		}
		return vets;
	}

}
