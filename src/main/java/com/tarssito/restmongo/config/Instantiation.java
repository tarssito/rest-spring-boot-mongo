package com.tarssito.restmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tarssito.restmongo.domain.Post;
import com.tarssito.restmongo.domain.User;
import com.tarssito.restmongo.repositories.PostRepository;
import com.tarssito.restmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", 
				"vou viajar pra São Paulo. Abraços", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", 
				"Acordei feliz hoje!", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
