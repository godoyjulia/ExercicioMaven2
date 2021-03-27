package com.jgodoy;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.Reader;

public class App {
    public static void main(String[] args) throws Exception {
			
		try ( 

			//veiculo passageiro
			Reader reader1 = Files.newBufferedReader(Paths.get("/workspaces/Projetos2/ExercicioMaven/src/main/java/com/jgodoy/ListaVeiculoPassageiro.csv")); 
			CSVParser csvParser1 = new CSVParser(reader1, CSVFormat.DEFAULT); 

			//veiculo passeio
			Reader reader2 = Files.newBufferedReader(Paths.get("/workspaces/Projetos2/ExercicioMaven/src/main/java/com/jgodoy/ListaVeiculoPasseio.csv")); 
			CSVParser csvParser2 = new CSVParser(reader2, CSVFormat.DEFAULT); 

			//veiculo utilitario
			Reader reader3 = Files.newBufferedReader(Paths.get("/workspaces/Projetos2/ExercicioMaven/src/main/java/com/jgodoy/ListaVeiculoUtilitario.csv")); 
			CSVParser csvParser3 = new CSVParser(reader3, CSVFormat.DEFAULT); 
		) { 

			System.out.println("Veiculos de Passageiros:");
			for (CSVRecord csvRecord : csvParser1) { 

				if (csvRecord.getRecordNumber() >1){//para não pegar o "cabeçalho"
					
					String placa = csvRecord.get(0); 
					String marca = csvRecord.get(1);
					String modelo = csvRecord.get(2);
					int ano = Integer.parseInt(csvRecord.get(3));
					double preco = Double.parseDouble(csvRecord.get(4)); 
					int nroPass = Integer.parseInt(csvRecord.get(5));

					VeiculoPassageiros v = new VeiculoPassageiros (
						placa, marca, modelo, ano, preco, nroPass
					);

					System.out.println("Record No - " + csvRecord.getRecordNumber());
					System.out.println("---------------");
					System.out.println("Tipo   : "  + v.getTipo());
					System.out.println("Placa  : "  + v.getPlaca());
					System.out.println("Marca  : "  + v.getMarca()); 
					System.out.println("Modelo : "  + v.getModelo()); 
					System.out.println("Preço  : "  + v.getValor()); 
					System.out.println("---------------\n\n"); 

				}		
			}

			System.out.println("Veiculos de Passeio:");
			for (CSVRecord csvRecord : csvParser2) { 

				if (csvRecord.getRecordNumber() >1){//para não pegar o "cabeçalho"
						
					String placa = csvRecord.get(0); 
					String marca = csvRecord.get(1);
					String modelo = csvRecord.get(2);
					int ano = Integer.parseInt(csvRecord.get(3));
					double preco = Double.parseDouble(csvRecord.get(4)); 
					double consumo = Double.parseDouble(csvRecord.get(5));

					VeiculoPasseio v = new VeiculoPasseio (
						placa, marca, modelo, ano, preco, consumo
					);

					System.out.println("Record No - " + csvRecord.getRecordNumber());
					System.out.println("---------------");
					System.out.println("Tipo   : "  + v.getTipo());
					System.out.println("Placa  : "  + v.getPlaca());
					System.out.println("Marca  : "  + v.getMarca()); 
					System.out.println("Modelo : "  + v.getModelo()); 
					System.out.println("Preco  : "  + v.getValor()); 
					System.out.println("---------------\n\n"); 

				}		
			}

			System.out.println("Veiculos Utilitários:");
			for (CSVRecord csvRecord : csvParser3) { 

				if (csvRecord.getRecordNumber() >1){//para não pegar o "cabeçalho"
						
					String modelo = csvRecord.get(0); 
					String placa = csvRecord.get(1);
					String marca = csvRecord.get(2);
					double preco = Double.parseDouble(csvRecord.get(3)); 
					int capTon = Integer.parseInt(csvRecord.get(4));
					int nroEixo = Integer.parseInt(csvRecord.get(5));
					int ano = Integer.parseInt(csvRecord.get(6));
					

					VeiculoUtilitario v = new VeiculoUtilitario (
						modelo, placa, marca, preco, capTon, nroEixo, ano
					);

					System.out.println("Record No - " + csvRecord.getRecordNumber());
					System.out.println("---------------");
					System.out.println("Tipo   : "  + v.getTipo());
					System.out.println("Placa  : "  + v.getPlaca());
					System.out.println("Marca  : "  + v.getMarca()); 
					System.out.println("Modelo : "  + v.getModelo()); 
					System.out.println("Preco  : "  + v.getValor()); 
					System.out.println("---------------\n\n"); 

				}	
			}

		}//fecha try
		catch(Exception e){
			System.out.println("erro:" + e.getMessage());
		}

	}
}
