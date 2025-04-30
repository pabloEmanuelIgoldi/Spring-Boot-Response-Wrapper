package com.respwrapper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.respwrapper.dto.ApiResponseDTO;
import com.respwrapper.dto.ProductoDTO;
import com.respwrapper.util.CodeResponseUtil;
import com.respwrapper.util.MensajeResponseUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/demo")
public class DemoController {

	@GetMapping("/ok")
	public ResponseEntity<ApiResponseDTO<List<ProductoDTO>>> ok() {
		List<ProductoDTO> data = this.mockProductos();
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO<>(true, MensajeResponseUtil.SUCCESS,
				CodeResponseUtil.SUCCESS, LocalDateTime.now(), data));
	}

	@PostMapping("/created")
	public ResponseEntity<ApiResponseDTO<List<ProductoDTO>>> post(@RequestBody ProductoDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDTO<>(true, MensajeResponseUtil.CREATED,
				CodeResponseUtil.CREATED, LocalDateTime.now(), null));
	}

	@GetMapping("/not-found/{id}")
	public ResponseEntity<ApiResponseDTO<String>> notFound(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO<>(false,
				MensajeResponseUtil.ENTITY_NOT_FOUND, CodeResponseUtil.ENTITY_NOT_FOUND, LocalDateTime.now(), null));
	}

	@PostMapping("/exists")
	public ResponseEntity<ApiResponseDTO<List<ProductoDTO>>> existente(@RequestBody ProductoDTO dto) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ApiResponseDTO<>(false, MensajeResponseUtil.ENTITY_ALREADY_EXISTS,
						CodeResponseUtil.ENTITY_ALREADY_EXISTS, LocalDateTime.now(), null));
	}

	@PostMapping("/bad-request")
	public ResponseEntity<ApiResponseDTO<List<ProductoDTO>>> malRequest(@RequestBody ProductoDTO dto) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDTO<>(false,
				MensajeResponseUtil.VALIDATION_ERROR, CodeResponseUtil.VALIDATION_ERROR, LocalDateTime.now(), null));
	}

	@GetMapping("/unauthorized")
	public ResponseEntity<ApiResponseDTO<String>> denegado() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponseDTO<>(false,
				MensajeResponseUtil.UNAUTHORIZED, CodeResponseUtil.UNAUTHORIZED, LocalDateTime.now(), null));
	}

	@GetMapping("/error")
	public ResponseEntity<ApiResponseDTO<String>> erroGeneral() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<>(false,
				MensajeResponseUtil.INTERNAL_ERROR, CodeResponseUtil.INTERNAL_ERROR, LocalDateTime.now(), null));
	}

	private List<ProductoDTO> mockProductos() {
		List<ProductoDTO> productos = new ArrayList<>();
		productos.add(ProductoDTO.builder().id(234L).nombre("Latop Dell Inspiron 3535").precio(1245000.0).build());
		productos.add(ProductoDTO.builder().id(2111L).nombre("Placa red Pci Express").precio(32456.9).build());
		productos.add(ProductoDTO.builder().id(24679L).nombre("Disco SSD Kingston 480 GB").precio(32456.9).build());
		return productos;
	}

}
