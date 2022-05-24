package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.EntradaDAOImpl;
import br.com.fiap.jpa.entity.Entrada;
import br.com.fiap.jpa.service.GenericService;

public class EntradaServiceImpl extends GenericService<Entrada, Long>{
	private static EntradaServiceImpl instance = null;
	
	private EntradaDAOImpl dao;
	
	private EntradaServiceImpl() {
		dao = EntradaDAOImpl.getInstance();
	}
	
	public static EntradaServiceImpl getInstance() {
		if (instance == null) {
			instance = new EntradaServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void inserir(Entrada entrada) {
		try {
			dao.salvar(entrada, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void atualizar(Entrada entrada) {
		try {
			dao.atualizar(entrada, getEntityManager());
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
	public Entrada obter(Long id) {
		Entrada entrada = null;
		try {
			entrada = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return entrada;
	}

	@Override
	public List<Entrada> listar() {
		List<Entrada> entradas = null;
		try {
			entradas = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return entradas;
	}
}
