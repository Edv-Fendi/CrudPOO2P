package application;
import model.dao.ColaboradorDao;
import model.dao.EnderecoDao;
import model.entities.Endereco;
import model.entities.Porte;
import model.dao.DaoFactory;
import model.dao.PorteDao;
import model.entities.Colaborador;

import java.util.List;
import java.util.Scanner;

public class Funcoes {
    // eixo
    static void updatePorte() {
        Scanner sc = new Scanner(System.in);
        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("\n=== TEST 4: update =======");
        System.out.println("informe o id que deseja atualizar");
        Porte porte = porteDao.findById(sc.nextInt());
        System.out.println("digite o codigo:");
        int cod = Integer.parseInt(sc.next());
        System.out.println("digite a descricao:");
        sc.nextLine();// para limpar o buffer e liberar a proxima pergunta
        String desc = sc.nextLine();
        porte.setId_Porte(cod);
        porte.setNome(desc);
        porteDao.update(porte);
        System.out.println("Update completed");
        sc.close();

    }

    static void findIdPorte() {
        Scanner sc = new Scanner(System.in);

        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("=== TEST 1: findById =======");
        System.out.println("informe o id a ser exibido");
        Porte dep = porteDao.findById(sc.nextInt());
        System.out.println(dep);
        sc.close();

    }

    static void findAllPorte() {
        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("\n=== TEST 2: findAll =======");
        List<Porte> list = porteDao.findAll();
        for (Porte d : list) {
            System.out.println(d);
        }

    }

    static void insertPorte() {
        Scanner sc = new Scanner(System.in);

        PorteDao porteDao = DaoFactory.createPorteDao();
        System.out.println("\n=== TEST 3: insert =======");
        System.out.println("digite o codigo");
        int cod = Integer.parseInt(sc.next());
        System.out.println("digite a descricao");
        sc.nextLine();
        String desc = sc.nextLine();
        Porte newPorte = new Porte(cod, desc);
        porteDao.insert(newPorte);
        System.out.println("Inserted! New id: " + newPorte.getId_Porte());
        sc.close();
    }

    static void deletePorte() {
        Scanner sc = new Scanner(System.in);

        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int cod = Integer.parseInt(sc.next());
        porteDao.deleteById(cod);
        System.out.println("Delete completed");
        sc.close();
    }

    static void updateEndereco() {
        Scanner sc = new Scanner(System.in);
        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
        System.out.println("\n=== TEST 4: update =======");
        System.out.println("informe o id que deseja atualizar");
        Endereco endereco = enderecoDao.findById(sc.nextInt());
        System.out.println("Digite a Cidade: ");
        sc.nextLine();
        endereco.setCidade(sc.nextLine());
        System.out.println("Digite o Numero: ");
        sc.nextLine();
        endereco.setNumero(sc.nextLine());
        System.out.println("Digite o Estado: ");
        sc.nextLine();
        endereco.setEstado(sc.nextLine());
        System.out.println("Digite o Bairro");
        sc.nextLine();
        endereco.setBairro(sc.nextLine());
        System.out.println("Digite o CEP");
        sc.nextLine();
        endereco.setCep(sc.nextLine());
        System.out.println("Digite o Complemento");
        sc.nextLine();
        endereco.setComplemento(sc.nextLine());
        enderecoDao.update(endereco);
        System.out.println("Update completed");
        sc.close();

    }

    static void findIdEndereco() {
        Scanner sc = new Scanner(System.in);

        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("=== TEST 1: findById =======");
        System.out.println("informe o id a ser exibido");
        Endereco endereco = enderecoDao.findById(sc.nextInt());
        System.out.println(endereco);
        sc.close();

    }

    static void findAllEndereco() {
        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== TEST 2: findAll =======");
        List<Endereco> list = enderecoDao.findAll();
        for (Endereco endereco : list) {
            System.out.println(endereco);
        }

    }

    static void insertEndereco() {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== TEST 3: insert =======");
        System.out.println("Digite a Cidade: ");
        String cidade = sc.nextLine();
        System.out.println("Digite o Numero: ");
        sc.nextLine();
        String numero = sc.nextLine();
        System.out.println("Digite o Estado: ");
        String estado = sc.nextLine();
        System.out.println("Digite o Bairro");
        String bairro = sc.nextLine();
        System.out.println("Digite o CEP");
        String cep = sc.nextLine();
        System.out.println("Digite o Complemento");
        String complemento = sc.nextLine();

        Endereco newEndereco = new Endereco(null, cidade, numero, estado, bairro, cep, complemento);
        enderecoDao.insert(newEndereco);

        System.out.println("Inserted! New id: " + newEndereco.getId_Endereco());
        sc.close();
        sc2.close();
    }

    static void deleteEndereco() {
        Scanner sc = new Scanner(System.in);

        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        enderecoDao.deleteById(id);
        System.out.println("Delete completed");
        sc.close();
    }


    static void updateColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Update Colaborador ===");
        System.out.println("Enter the ID of the Colaborador to update:");
        int id = sc.nextInt();
        Colaborador colaborador = colaboradorDao.findById(id);

        if (colaborador != null) {
            System.out.println("Enter the new Nome:");
            sc.nextLine(); // Clear the buffer
            String nome = sc.nextLine();
            System.out.println("Enter the new Telefone:");
            String telefone = sc.next();
            System.out.println("Enter the new Email:");
            String email = sc.next();
            System.out.println("Enter the new Funcao:");
            String funcao = sc.next();
            System.out.println("Enter the new Setor:");
            String setor = sc.next();
            System.out.println("Is this Colaborador an Admin? (true or false):");
            boolean isAdmin = sc.nextBoolean();

            colaborador.setNome(nome);
            colaborador.setTelefone(telefone);
            colaborador.setEmail(email);
            colaborador.setFuncao(funcao);
            colaborador.setSetor(setor);
            colaborador.setAdmin(isAdmin);

            colaboradorDao.update(colaborador);
            System.out.println("Colaborador updated successfully.");
        } else {
            System.out.println("Colaborador not found.");
        }

        sc.close();
    }



    static void findAllColaborador() {
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Find All Colaboradores ===");
        List<Colaborador> colaboradores = colaboradorDao.findAll();
        for (Colaborador colaborador : colaboradores) {
            System.out.println(colaborador);
        }
    }

    static void insertColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Insert Colaborador ===");
        System.out.println("Digite o Nome :");
        String nome = sc.next();
        System.out.println("Digite o Telefone:");
        String telefone = sc.next();
        System.out.println("Digite o Email:");
        String email = sc.next();
        System.out.println("Digite o Funcao:");
        String funcao = sc.next();
        System.out.println("Digite o Setor:");
        String setor = sc.next();
        System.out.println("O Colaborador é Admin? (True ou False):");
        boolean isAdmin = sc.nextBoolean();

        Colaborador newColaborador = new Colaborador(nome, telefone,email,funcao,setor,isAdmin );


        colaboradorDao.insert(newColaborador);
        System.out.println("Colaborador inserted successfully.");
        sc.close();
    }

    static void deleteColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Delete Colaborador ===");
        System.out.println("Enter the ID of the Colaborador to delete:");
        int id = sc.nextInt();

        colaboradorDao.deleteById(id);
        System.out.println("Colaborador deleted successfully.");
        sc.close();
    }

    static void findIdColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao1 = DaoFactory.createColaboradorDao();

        System.out.println("=== Find Colaborador by ID ===");
        System.out.println("Enter the ID of the Colaborador to find:");
        int id = sc.nextInt();
        ColaboradorDao colaboradorDao = (ColaboradorDao) DaoFactory.createEnderecoDao();

        sc.close();
    }

}