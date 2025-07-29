package com.sinensia.polloschicharron.presentation.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.polloschicharron.business.model.Pedido;
import com.sinensia.polloschicharron.business.services.PedidoServices;


@Controller
@RequestMapping("/app")
public class PedidoAppController {

	private PedidoServices pedidoServices;

	public PedidoAppController(PedidoServices pedidoServices) {
		this.pedidoServices = pedidoServices;
	}
	
	@GetMapping("/lista-pedidos")
	public ModelAndView getListaPedidos(ModelAndView mav) {
		mav.addObject("pedidos", pedidoServices.getPedidosDTO1());
		mav.setViewName("listado-pedidos");
		return mav;
	}
	
	
	@GetMapping("/pedido")
	public ModelAndView getPedido(ModelAndView mav, @RequestParam Long id) {
		// Verificar si el pedido está presente en el Optional
		Optional<Pedido> pedidoOptional = pedidoServices.read(id);
		
		if (pedidoOptional.isPresent()) {
			// Si está presente, agregamos el objeto al ModelAndView
			mav.addObject("pedido", pedidoOptional.get());
		} else {
			// Si no está presente, puedes manejar el caso de error o mostrar un mensaje
			mav.addObject("error", "Pedido no encontrado");
		}
		
		// Establecer la vista a renderizar
		mav.setViewName("pedido");
		return mav;
}
	
	
}
