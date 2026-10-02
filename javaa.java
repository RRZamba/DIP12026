import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientChat 
{
	public static void main(String[] args) 
	{
		// CAMADA 7 (APLICAÇÃO): Interface de entrada do usuário para capturar o IP do servidor (L3)
		String ipServer = JOptionPane
			.showInputDialog("Digite o IP, seu otário!!!");
 	
		// CAMADA 7 (APLICAÇÃO): Interface de entrada do usuário para capturar o nome
		String nominho = JOptionPane
				   .showInputDialog("Digite seu belo nome:");
		
		// CAMADA 4 (TRANSPORTE): Definição do número da porta de destino para identificar o processo
		int porta = 12345;
		
		try 
		{
			// CAMADA 3 (REDE) + CAMADA 4 (TRANSPORTE) + CAMADA 5 (SESSÃO):
			// Tenta estabelecer a sessão TCP (L5/L4) usando o IP informado (L3) e a Porta (L4)
			Socket portinha = new Socket(ipServer,porta);
			
			// CAMADA 6 (APRESENTAÇÃO): Prepara o fluxo de saída para formatar e codificar os caracteres enviados
			PrintWriter saidera = new 
					  PrintWriter(portinha.getOutputStream(),true);
			
			// CAMADA 7 (APLICAÇÃO) / CAMADA 6 (APRESENTAÇÃO):
			// Constrói a mensagem da aplicação e a envia formatada com quebra de linha
			saidera.println("Olá querido professor!!!, sou o " + nominho);
			
			// CAMADA 5 (SESSÃO): Finaliza a sessão ativa do lado do cliente
			portinha.close();
			
			// CAMADA 7 (APLICAÇÃO): Notificação visual de sucesso para o usuário
			JOptionPane.showMessageDialog(null,
					"Mensagem enviada com sucesso ao IP: " + ipServer);
		} 
		catch (Exception e) 
		{
			// CAMADA 7 (APLICAÇÃO): Exibição da caixa de diálogo gráfica com mensagem de erro
			JOptionPane.showMessageDialog(null, 
					"ERRO: Não foi Possível conectar no servidor!!!",
			        "Erro de Rede!!!",JOptionPane.ERROR_MESSAGE);
		}
	}

}