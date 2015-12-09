package rivers.yeah.research.yelda;

import java.io.File;

import org.junit.Test;

public class Main {

	//delete	
	//branch master feature

	public static void main(String[] args) {
		String configPath = "./cfg/yelda.properties";
		LdaArgs option = LdaArgs.initLdaArgs(configPath);
		try {
			if (!option.initflag){
				System.out.println("Args init failed!");
				return;
			}
			
			if (1 == option.est || 1 == option.estc){
				Trainer trainer = new Trainer();
				if (!trainer.init(option)) {
					System.out.println("Trainer init failed!");
					return;
				}
				trainer.train();
			}
			else if (1 == option.inf){
				Inferencer inferencer = new Inferencer(option);
				if (!inferencer.init()) {
					System.out.println("Inferencer init failed!");
					return;
				}
				
				inferencer.inference();
			}
		}
		catch (Exception e){
			System.out.println("Error in main: " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}
}
