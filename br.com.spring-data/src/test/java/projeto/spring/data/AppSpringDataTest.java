package projeto.spring.data;


import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.spring.data.dao.InterfaceSpringDataTelefone;
import br.com.spring.data.dao.InterfaceSpringDataUser;
import br.com.spring.data.model.TelefoneSpringData;
import br.com.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceSpringDataTelefone interfaceSpringDataTelefone;
	
	@Test
	public void testaInsert() {
		
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("java@java.com.br2");
		usuarioSpringData.setIdade(29);
		usuarioSpringData.setLogin("admin2");
		usuarioSpringData.setSenha("admin2");
		usuarioSpringData.setNome("jhonatan2");
		
		interfaceSpringDataUser.save(usuarioSpringData);
	}
	
	@Test
	public void testaConsultaId() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getId());
		
		
		for(TelefoneSpringData telefone : usuarioSpringData.get().getTelefone()) {
			
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
		}
		
	}
	
	@Test
	public void testaBuscaTodoRegistro() {
		
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("<----------------------------------------->");
		}
		
		
		
	}
	
	@Test
	public void testaUpdate() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		UsuarioSpringData usuario = usuarioSpringData.get();
		
		
		usuario.setNome("lindao");
		
		
		interfaceSpringDataUser.save(usuario);	
		
		
	}
	
	@Test
	public void testaDelete() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		interfaceSpringDataUser.delete(usuarioSpringData.get());
		
	}
	
	@Test
	public void testaBuscaPorNome() {
		
		List<UsuarioSpringData> lista = interfaceSpringDataUser.buscaPorNome("j");
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("<----------------------------------------->");
		}
		
		
	}
	
	@Test
	public void testaBuscaPorParametroIdentico() {
		
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("jhonatan");
		
		
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
	
		
	}
	
	@Test
	public void testaDeletaPorNome() {
		interfaceSpringDataUser.deletaPorNome("jhonatan2");
	}
	
	@Test
	public void testaUpadateEmailPorNome() {
		
		interfaceSpringDataUser.updateEmailPorNome("jhonatan@gmail", "jhonatan");
	}
	
	@Test
	public void testaInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		TelefoneSpringData telefone = new TelefoneSpringData();
		
		telefone.setNumero("36719696");
		telefone.setTipo("ramal");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceSpringDataTelefone.save(telefone);
		
	}

}
