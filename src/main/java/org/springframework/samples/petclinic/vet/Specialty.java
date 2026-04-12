// Done
// JPA Entity: Thuộc dạng model layer trong mô hình MVC

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

import org.springframework.samples.petclinic.model.NamedEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Đây là một JPA Entity → tức là một class Java được ánh xạ thành bảng trong database.
 * Thường trong 1 package thì JPA Entity thường viết trong 1 folder là "enity"
 *
 * @Entity → đánh dấu đây là bảng DB
 * @Table(name = "specialties") → bảng tương ứng tên là specialties extends NamedEntity →
 * kế thừa một class cha (thường chứa id, name)
 */
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {

	// Thường no chứa các thuộc tính hoặc phương thức sau (optional, có thể có hoặc không)
	// project này đã lược bớt

	// ===== 1. PRIMARY KEY =====
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Integer id;
	//
	// // ===== 2. BUSINESS FIELD =====
	// @Column(name = "name", nullable = false)
	// private String name;
	//
	// // ===== 3. RELATIONSHIP =====
	// @ManyToMany(mappedBy = "specialties")
	// private Set<Vet> vets = new HashSet<>();
	//
	// // ===== 4. CONSTRUCTORS =====
	// public Specialty() {}
	//
	// public Specialty(String name) {
	// this.name = name;
	// }
	//
	// // ===== 5. GETTER / SETTER =====
	// public Integer getId() {
	// return id;
	// }
	//
	// public void setId(Integer id) {
	// this.id = id;
	// }
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public Set<Vet> getVets() {
	// return vets;
	// }
	//
	// public void setVets(Set<Vet> vets) {
	// this.vets = vets;
	// }
	//
	// // ===== 6. OPTIONAL: helper methods =====
	// public void addVet(Vet vet) {
	// this.vets.add(vet);
	// vet.getSpecialties().add(this);
	// }
	//
	// public void removeVet(Vet vet) {
	// this.vets.remove(vet);
	// vet.getSpecialties().remove(this);
	// }
	//
	// // ===== 7. toString (debug) =====
	// @Override
	// public String toString() {
	// return "Specialty{id=" + id + ", name='" + name + "'}";
	// }

}
