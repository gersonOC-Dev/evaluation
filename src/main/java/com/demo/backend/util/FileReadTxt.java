package com.demo.backend.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.backend.model.User;

@Component
public class FileReadTxt {
	
	private static String ruta = "src/main/resources/users/usuarios.txt";
	
	public boolean validateUser(String user, String password) throws IOException {
		
		List<User> listUser = readText();
		
		List<User> users = listUser.stream()
				.filter(rs -> rs.getUser().equals(user) && rs.getPassword().equals(password))
				.collect(Collectors.toList());
		
		return users.size()>0 ? Boolean.TRUE : Boolean.FALSE;
	}
	
	
	
	
	
	private  List<User> readText() throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream(ruta);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
		
		String line;
		List<User> users = new ArrayList<User>();
		
		try {
			while((line = br.readLine()) != null) {
				String[] data = line.split(",",2);
				users.add(User.builder()
						.user(data[0])
						.password(data[1])
						.build());
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		br.close();
		
		return users;
	}

}
