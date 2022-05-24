package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fiap.jpa.entity.Entrada;
import br.com.fiap.jpa.entity.Evento;
import br.com.fiap.jpa.entity.MovimentacaoEntrada;
import br.com.fiap.jpa.entity.Participante;
import br.com.fiap.jpa.service.impl.EntradaServiceImpl;
import br.com.fiap.jpa.service.impl.EventoServiceImpl;
import br.com.fiap.jpa.service.impl.MovimentacaoEntradaServiceImpl;
import br.com.fiap.jpa.service.impl.ParticipanteServiceImpl;

public class App {

	public static void main(String[] args) {
		EventoServiceImpl eventoServiceImpl = EventoServiceImpl.getInstance();
		EntradaServiceImpl entradaServiceImpl = EntradaServiceImpl.getInstance();
		ParticipanteServiceImpl participanteServiceImpl = ParticipanteServiceImpl.getInstance();
		MovimentacaoEntradaServiceImpl movimentacaoEntradaServiceImpl = MovimentacaoEntradaServiceImpl.getInstance();
		
		/**
		 * Cadastrar um novo evento
		 */
		Evento evento = new Evento("Congresso de TI", LocalDate.of(2022, 1, 1));
		
		eventoServiceImpl.inserir(evento);
		
		Entrada entrada1 = new Entrada(1, "Entrada Norte", evento);
		
		Entrada entrada2 = new Entrada(2, "Entrada Sul", evento);
		
		entradaServiceImpl.inserir(entrada1);
		entradaServiceImpl.inserir(entrada2);
		
		Participante participante1 = participanteServiceImpl.obter(1L);
		Participante participante2 = participanteServiceImpl.obter(2L);
		
		MovimentacaoEntrada movimentacao1 = new MovimentacaoEntrada("E", LocalDateTime.of(2002,  1, 1, 1, 15, 0), entrada1, participante1);
		MovimentacaoEntrada movimentacao2 = new MovimentacaoEntrada("E", LocalDateTime.of(2002,  1, 1, 14, 27, 0), entrada1, participante2);
		MovimentacaoEntrada movimentacao3 = new MovimentacaoEntrada("S", LocalDateTime.of(2002,  1, 1, 15, 52, 0), entrada1, participante1);
		MovimentacaoEntrada movimentacao4 = new MovimentacaoEntrada("S", LocalDateTime.of(2002,  1, 1, 16, 31, 0), entrada1, participante2);
		
		movimentacaoEntradaServiceImpl.inserir(movimentacao1);
		movimentacaoEntradaServiceImpl.inserir(movimentacao2);
		movimentacaoEntradaServiceImpl.inserir(movimentacao3);
		movimentacaoEntradaServiceImpl.inserir(movimentacao4);
		
		
		/**
		 * Lista todas as movimentações com base no tipode movimentação
		 */
		movimentacaoEntradaServiceImpl.listarPorTipo("E").forEach(System.out::println);
		
		/**
		 * Lista todas as movimentações com base no tipode movimentação
		 */
		participanteServiceImpl.pesquisar("JosÃ©","444.444.444-44",LocalDate.of(1998, 1, 1)).forEach(System.out::println);
		
	}
}
