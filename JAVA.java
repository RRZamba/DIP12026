import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat 
{

	public static void main(String[] args) 
	{
		// CAMADA 4 (TRANSPORTE): Criação do ServerSocket usando TCP na porta 12345
		try(ServerSocket servidor = new ServerSocket(12345)) 
		{
			// CAMADA 3 (REDE): Obtenção do endereço IP local do servidor
			// CAMADA 7 (APLICAÇÃO): Exibição do status no console/interface
			System.out.println("Servidor Aberto no IP: " 
			     + InetAddress.getLocalHost().getHostAddress());
			System.out.println("Aguardando mensagens dos alunos fofos...");
			
			//Aguardando os pacotes
			while(true) 
			{
				// CAMADA 5 (SESSÃO): Estabelece e aceita a conexão/sessão individual com cada cliente
				Socket cliente = servidor.accept();
				
				// CAMADA 6 (APRESENTAÇÃO): Leitura do fluxo de bytes recebido e conversão para caracteres/texto
				BufferedReader entrada = 
					   new BufferedReader(
							   new InputStreamReader(cliente.getInputStream()));
				
				// CAMADA 6 (APRESENTAÇÃO): Interpreta a quebra de linha (\n) para formar a mensagem completa
				String mensagem = entrada.readLine();
				
				// CAMADA 7 (APLICAÇÃO): Exibição do dado processado para o usuário final no console
				System.out.println("MENSAGEM RECEBIDA: " + mensagem);
				
				// CAMADA 5 (SESSÃO): Encerra a sessão de comunicação com este cliente específico
				cliente.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
}