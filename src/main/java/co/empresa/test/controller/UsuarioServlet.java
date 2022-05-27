package co.empresa.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.test.dao.CandidatoDao;
import co.empresa.test.dao.CandidatoDaoFactory;
import co.empresa.test.dao.EleccionDao;
import co.empresa.test.dao.EleccionDaoFactory;
import co.empresa.test.dao.EstamentoDao;
import co.empresa.test.dao.EstamentoDaoFactory;
import co.empresa.test.dao.TipoDocumentoDao;
import co.empresa.test.dao.TipoDocumentoDaoFactory;
import co.empresa.test.dao.UsuarioDao;
import co.empresa.test.dao.UsuarioDaoFactory;
import co.empresa.test.dao.UsuarioDaoMySQL;
import co.empresa.test.dao.UsuarioDaoPostgreSQL;
import co.empresa.test.dao.VotanteDao;
import co.empresa.test.dao.VotanteDaoFactory;
import co.empresa.test.dao.VotoDao;
import co.empresa.test.dao.VotoDaoFactory;
import co.empresa.test.modelo.Candidato;
import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.Estamento;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.modelo.Votante;
import co.empresa.test.modelo.Voto;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao;
	private TipoDocumentoDao tipoDocumentoDao;
	private EleccionDao eleccionDao;
	private VotanteDao votanteDao;
	private CandidatoDao candidatoDao;
	private EstamentoDao estamentoDao;
	private VotoDao votoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
    }
    
    public void init() throws ServletException {
		String type = getServletContext().getInitParameter("type");
		this.usuarioDao = UsuarioDaoFactory.getUsuarioDao(type);
		this.tipoDocumentoDao = TipoDocumentoDaoFactory.getTipoDocumentoDao(type);
		this.eleccionDao = EleccionDaoFactory.getEleccionDao(type);
		this.votanteDao = VotanteDaoFactory.getVotanteDao(type);
		this.candidatoDao = CandidatoDaoFactory.getCandidatoDao(type);
		this.estamentoDao = EstamentoDaoFactory.getEstamentoDao(type);
		this.votoDao = VotoDaoFactory.getVotoDao(type);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		try {
		switch(action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarUsuario(request, response);
				break;
			case "/delete":
				eliminarUsuario(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarUsuario(request, response);
				break;
				
			case "/updateCandidato":
				actualizarCandidato(request, response);
				break;
			case "/editCandidato":
				editarCandidato(request, response);
				break;
				
			case "/votar":
				showVotacion(request, response);
				break;
			case "/validar":
				validarVotante(request, response);
				break;
			case "/procesoVotacion":
				insertarVoto(request, response);
				break;
			case "/inicio":
				showIndex(request, response);
				break;
			case "/candidato":
				showCandidato(request, response);
				break;
			case "/votante":
				showVotante(request, response);
				break;
			case "/insertVotante":
				insertarVotante(request, response);
				break;
				
			case "/insertarCandidato":
				insertarCandidato(request, response);
				break;
				
			default:
				showIndex(request, response);
				break;
		
		}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showVotacion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		List <Votante> listvotantes = votanteDao.selectAll();
		
		List <Voto> listVoto = votoDao.selectAll();
		
		
		for(int i = 0 ; i<listVoto.size(); i++) { //1
			for(int j = 0 ; j<listvotantes.size(); j++) { //3
				if(listvotantes.get(j).getId().equals(listVoto.get(i).getVotante().getId())) {
					
					listvotantes.remove(j);
					j = listvotantes.size();
				}
			}
		}
		
		List <Votante> nueva = new ArrayList();
		nueva = listvotantes;
		
		request.setAttribute("listvotantes", nueva);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("validar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void validarVotante(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Votante votanteActual = votanteDao.select(id);
		
		List <Estamento> listestamento = estamentoDao.selectAll();
		List <Candidato> listcandidato = candidatoDao.selectAll();
		
		List <Object> listas = new ArrayList<>();
		listas.add(votanteActual);
		listas.add(listestamento);
		listas.add(listcandidato);
		
		request.setAttribute("listas", listas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("voto.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarVoto(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		String fechacreacion = request.getParameter("fechacreacion");
		String fechavoto = request.getParameter("fechavoto");
		String uuid = request.getParameter("uuid");
		String enlace = request.getParameter("enlace");
		int est = Integer.parseInt(request.getParameter("estamento"));
		Estamento estamento = new Estamento();
		estamento.setId(est);
		
		
		int can = Integer.parseInt(request.getParameter("candidato"));
		Candidato candidato = new Candidato();
		candidato.setId(can);
		
		int vot = Integer.parseInt(request.getParameter("votante"));
		Votante votante = new Votante();
		votante.setId(vot);
		
		Voto usuario = new Voto (fechacreacion, fechavoto, uuid, enlace, estamento, candidato, votante);
		
		votoDao.insert(usuario);
		
		response.sendRedirect("inicio");
	}
	
	
	private void showIndex(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List <Candidato> listcandidato = candidatoDao.selectAll();
		request.setAttribute("listCandidatos", listcandidato);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showCandidato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List <Eleccion> listEleccion = eleccionDao.selectAll();
		request.setAttribute("listEleccion", listEleccion);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showVotante(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List <TipoDocumento> listTiposDocumentos = tipoDocumentoDao.selectAll();
		List <Eleccion> listEleccion = eleccionDao.selectAll();
		
		List <Object> listas = new ArrayList<>();
		listas.add(listTiposDocumentos);
		listas.add(listEleccion);
		
		request.setAttribute("listas", listas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("votante.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		Usuario usuario = new Usuario (nombre, email, pais);
		
		usuarioDao.insert(usuario);
		
		response.sendRedirect("list");
	}
	
	
	
	private void insertarVotante(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		String nombre = request.getParameter("nombre");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		TipoDocumento tipoDocumento = new TipoDocumento(Integer.parseInt(request.getParameter("tipodocumento")));
		Eleccion eleccion = new Eleccion(Integer.parseInt(request.getParameter("eleccion")));
		
		Votante usuario = new Votante (nombre, email, documento ,tipoDocumento,eleccion);
		
		votanteDao.insert(usuario);
		
		response.sendRedirect("inicio");
	}
	
	private void insertarCandidato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Eleccion proceso = new Eleccion(Integer.parseInt(request.getParameter("proceso")));
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		Candidato usuario = new Candidato (documento, nombre,apellido,proceso,numero);
		
		candidatoDao.insert(usuario);
		
		response.sendRedirect("inicio");
	}
	
	private void editarCandidato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Candidato usuarioActual = candidatoDao.select(id);
		
		List <Eleccion> listEleccion = eleccionDao.selectAll();
		
		List <Object> listas = new ArrayList<>();
		listas.add(usuarioActual);
		listas.add(listEleccion);
		
		
		request.setAttribute("listas", listas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void actualizarCandidato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		Usuario usuario = new Usuario (id, nombre, email, pais);
		
		usuarioDao.update(usuario);
		
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuarioActual = usuarioDao.select(id);
		
		request.setAttribute("usuario", usuarioActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		Usuario usuario = new Usuario (id, nombre, email, pais);
		
		usuarioDao.update(usuario);
		
		response.sendRedirect("list");
	}
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		usuarioDao.delete(id);
		
		response.sendRedirect("list");
	}
	
	private void listUsuarios(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		List <Usuario> listUsuarios = usuarioDao.selectAll();
		request.setAttribute("listUsuarios", listUsuarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuariolist.jsp");
		dispatcher.forward(request, response);		
	}
}