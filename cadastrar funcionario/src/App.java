import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        int op;
        do {
            
            
            System.out.println("1 Cadastrar \n2 Listar \n3 excluir \n4 sair");
            op = leia.nextInt();
            
            switch (op) {
                case 1:
                
                FuncionarioDTO funcionario = new FuncionarioDTO();
                
                System.out.println("Cadastrar funcionario\n");
                
                leia.nextLine();
                System.out.printf("Nome:");
                String nome = leia.nextLine();
                funcionario.setNome(nome);
                
                System.out.printf("Email:");
                String email = leia.next();
                funcionario.setEmail(email);

                    System.out.printf("Telefone:");
                    String tell = leia.next();
                    funcionario.setTell(tell);
                    
                    System.out.printf("Cpf:");
                    String cpf = leia.next();
                    funcionario.setCpf(cpf);
                    
                    new FuncionarioDAO().cadastrarFuncionario(funcionario);
                    
                break;
                
                case 2:
                    ArrayList<FuncionarioDTO> lista = new ArrayList<>();
                        lista = new FuncionarioDAO().pesquisarFuncionarios();
                        if(lista.size()!=0){
                            for (FuncionarioDTO a : lista) {
                                a.descricaoFuncionario();
                            }
                        }else{
                            System.out.println("Lista vazia");
                        }
                break;
                
                
                case 3:
                    FuncionarioDTO fc2 = new FuncionarioDTO();

                    System.out.println("Digite o codigo do produto que deseja alterar:");
                    int codigo = leia.nextInt();
                    fc2.setCodigo(codigo);

                    new FuncionarioDAO().excluirFunvionario(fc2);

                    System.out.println("Produto excluido!");
                break;

                
            }
            
            
        } while (op != 4);
        leia.close();
        }
    }
    