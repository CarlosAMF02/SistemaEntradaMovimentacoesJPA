package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.EventoDAOImpl;
import br.com.fiap.jpa.entity.Evento;
import br.com.fiap.jpa.service.GenericService;

public class EventoServiceImpl extends GenericService<Evento, Long>{
	
	private static EventoServiceImpl instance = null;
	
	private EventoDAOImpl dao;
	
	private EventoServiceImpl() {
		dao = EventoDAOImpl.getInstance();
	}
	
	public static EventoServiceImpl getInstance() {
		if (instance == null) {
			instance = new EventoServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void inserir(Evento evento) {
		try {
			dao.salvar(evento, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void atualizar(Evento evento) {
		try {
			dao.atualizar(evento, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			dao.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Evento obter(Long id) {
		Evento evento = null;
		try {
			evento = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return evento;
	}

	@Override
	public List<Evento> listar() {
		List<Evento> eventos = null;
		try {
			eventos = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return eventos;
	}
	
}
