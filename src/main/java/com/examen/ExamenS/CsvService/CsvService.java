package com.examen.ExamenS.CsvService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.ExamenS.model.Usuario;

@Service
public class CsvService {
	
	
	public void leector() {
	BufferedReader csvReader;
	try {
		csvReader = new BufferedReader(new FileReader("/home/mvu/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/ExamenS/src/main/java/com/examen/ExamenS/CsvService/aqui.csv"));
		String row="";
		Usuario usuario = new Usuario();
		try {
			while((row=csvReader.readLine())!=null) {
				String[] data = row.split(",");
				System.out.println(data[0]);
				System.out.println(data[1]);
				System.out.println(data[2]);
				System.out.println(data[3]);
				usuario.setId(Integer.parseInt(data[3]));
			}
			System.out.println(usuario.getId());
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void escritor(List<Usuario> usuarios) {
		try {
			Usuario usuario;
			FileWriter csvWritter = new FileWriter("/home/mvu/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/ExamenS/src/main/java/com/examen/ExamenS/CsvService/aqui.csv");
			for(int i=0;i<usuarios.size();i++) {
				usuario=usuarios.get(i);
				csvWritter.append((usuario.getApellidoP()+","+usuario.getApellidoM()+","+usuario.getNombre()+","+usuario.getId()+"\n"));
			}
			csvWritter.flush();
			csvWritter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}