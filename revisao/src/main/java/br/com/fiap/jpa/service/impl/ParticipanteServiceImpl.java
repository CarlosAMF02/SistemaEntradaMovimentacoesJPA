package br.com.fiap.jpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.jpa.dao.impl.ParticipanteDAOImpl;
import br.com.fiap.jpa.entity.Participante;
import br.com.fiap.jpa.service.GenericService;

public class ParticipanteServiceImpl extends GenericService<Participante, Long>{

	private static ParticipanteServiceImpl instance = null;
	
	private ParticipanteDAOImpl dao;
	
	private ParticipanteServiceImpl() {
		dao = ParticipanteDAOImpl.getInstance();
	}
	
	public static ParticipanteServiceImpl getInstance() {
		if (instance == null) {
			instance = new ParticipanteServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void inserir(Participante participante) {
		try {
			dao.salvar(participante, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void atualizar(Participante participante) {
		try {
			dao.atualizar(participante, getEntityManager());
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
	public Participante obter(Long id) {
		Participante participante = null;
		try {
			participante = dao.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return participante;
	}

	@Override
	public List<Participante> listar() {
		List<Participante> participantes = null;
		try {
			participantes = dao.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return participantes;
	}
	
	public List<Participante> pesquisar(String nome, String cpf, LocalDate dataCadastro) {
		List<Participante> participantes = null;
		try {
			participantes = dao.pesquisar(nome,cpf,dataCadastro,getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return participantes;
	}
}
