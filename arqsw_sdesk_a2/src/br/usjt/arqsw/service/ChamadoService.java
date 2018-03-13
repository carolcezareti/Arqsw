package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Carolina Cezareti 81620043
 *
 */
public class ChamadoService {
	private ChamadoDAO dao;
	
	public ChamadoService() {
		dao = new ChamadoDAO();
	}
	public ArrayList<Chamado> listarChamado(Fila fila) throws IOException{
		return dao.listarChamado(fila);
	}

}
