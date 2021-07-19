package com.nobelti.cl.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nobelti.cl.model.CommonResponse;
import com.nobelti.cl.model.Operacion;
import com.nobelti.cl.model.OperacionResponse;
import com.nobelti.cl.model.Proyecto;
import com.nobelti.cl.repository.OperacionRepository;
import com.nobelti.cl.repository.ProyectoRepository;


@RestController
@RequestMapping("/dal/track")
public class GenerarIdOperacionController {
	
	Logger logger = LoggerFactory.getLogger(GenerarIdOperacionController.class);
	
	@Autowired
	private OperacionRepository repoOperacion;
	@Autowired
	private ProyectoRepository repoProyecto;
	
	//PROYECTOS
	@GetMapping("/proyect/listar")
	public List<Proyecto> listarProyectos(){
		return  repoProyecto.findAll();
	}

	@GetMapping("/project/last")
	public Proyecto traerUltimoIdProyecto() {
		Proyecto ultimoProyectoRegistrado = repoProyecto.findTopByOrderByIdProjectDesc();
		return ultimoProyectoRegistrado;
	}
	@PostMapping("/project/create")
	public @ResponseBody CommonResponse agregarProyecto(@Param("id_proyecto") int id_proyecto, @Param("nombre_proyecto") String nombre_proyecto) {
		CommonResponse response = new CommonResponse();
		logger.info("idProyecto: "+id_proyecto);
		try {
			Proyecto proyecto = new Proyecto();
			proyecto.setIdProject(id_proyecto);
			proyecto.setProjectName(nombre_proyecto);
			proyecto.setCreatedDate(fechaActual());
			
			repoProyecto.save(proyecto);
			
			response.setCodigo(0);
			response.setMensaje("Proyecto añadido.");
		}catch (Exception e) {
			response.setCodigo(99);
			response.setMensaje("Error: " + e);
		}
		
		return response;
	}
	//OPERACIONES
	@GetMapping("/operation/listar")
	public List<Operacion> listarOperaciones(){
		return  repoOperacion.findAll();
	}
	
	@GetMapping("/operation/last")
	public Operacion traerUltimoIdOperacion() {
		Operacion ultimoProyectoRegistrado = repoOperacion.findTopByOrderByIdOperationDesc();
		return ultimoProyectoRegistrado;
	}
	@PostMapping("/operation/create")
	public OperacionResponse crearIdOperacion(@Param("id_operacion") int id_operacion,@Param("id_proyecto") int id_proyecto,@Param("nombre_operacion") String nombre_operacion) {
		OperacionResponse response = new OperacionResponse();
		try {
			Operacion operacion = new Operacion();
			operacion.setIdOperation(id_operacion);
			operacion.setIdProject(id_proyecto);
			operacion.setProxyName(nombre_operacion);
			
			repoOperacion.save(operacion);
			
			response.setCodigo(0);
			response.setMensaje("Operación añadida.");
			response.setIdOperacion(id_operacion);
			response.setNombreOperacion(nombre_operacion);
		}catch (Exception e) {
			response.setCodigo(99);
			response.setMensaje("Error: " + e);
		}
		
		return response;
	}
	
	
	@GetMapping("/operation")
	public List<Operacion> traerOperacionPorProyecto(@Param("id_proyecto") int id_proyecto){
		return repoOperacion.findAllByIdProject(id_proyecto);
	}
	
	private Date fechaActual()
	{
		LocalDateTime fecha = LocalDateTime.now();
		return java.sql.Timestamp.valueOf(fecha);
	}
}
