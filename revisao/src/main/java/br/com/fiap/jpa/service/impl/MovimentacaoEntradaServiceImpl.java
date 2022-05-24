package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.MovimentacaoEntradaDAOImpl;
import br.com.fiap.jpa.entity.MovimentacaoEntrada;
import br.com.fiap.jpa.service.GenericService;

public class MovimentacaoEntradaServiceImpl extends GenericService<MovimentacaoEntrada, Long> {
	
	private static MovimentacaoEntradaServiceImpl instance = null;
	
	private MovimentacaoEntradaDAOImpl dao;
	
	private MovimentacaoEntradaServiceImpl() {
		dao = MovimentacaoEntradaDAOImpl.getInstance();
	}
	
	public static MovimentacaoEntradaServiceImpl getInstance() {
		if (instance == null) {
			instance = new MovimentacaoEntradaServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void inserir(MovimentacaoEntrada movimentacaoEntrada) {
		try {
			dao.salvar(movimentacaoEntrada, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void atualizar(MovimentacaoEntrada movimentacaoEntrada) {
		try {
			dao.atualizar(movimentacaoEntrada, getEntityManager());
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
	public MovimentacaoEntrada obter(Long id) {
		MovimentacaoEntrada movimentacaoEntrada = null;
		try {
			movimentacaoEntrada = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return movimentacaoEntrada;
	}

	@Override
	public List<MovimentacaoEntrada> listar() {
		List<MovimentacaoEntrada> movimentacoes = null;
		try {
			movimentacoes = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return movimentacoes;
	}
	
	public List<MovimentacaoEntrada> listarPorTipo(String tipo) {
		List<MovimentacaoEntrada> movimentacoes = null;
		try {
			movimentacoes = dao.listarPorTipo(tipo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return movimentacoes;
	}
}
