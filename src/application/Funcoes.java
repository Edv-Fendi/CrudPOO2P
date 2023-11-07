package application;

import model.dao.*;
import model.entities.Empresa;
import model.entities.Endereco;
import model.entities.Porte;
import model.entities.Ramo;
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
    static void updatePorte() {
        Scanner sc = new Scanner(System.in);
        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("\n=== ATUALIZAÇÃO DE PORTE ===");
        System.out.println("Informe o ID para atualização:");
        int id = sc.nextInt();
        Porte porte = porteDao.findById(id);
        if (porte == null) {
            System.out.println("Porte não encontrado!");
            return;
        }
        System.out.println("Descrição atual: " + porte.getNome());
        System.out.println("Digite a nova descrição:");
        sc.nextLine(); // para limpar o buffer e liberar a proxima pergunta
        String desc = sc.nextLine();
        porte.setNome(desc); // You only set the new name, no need to set the ID again
        porteDao.update(porte);
        System.out.println("Porte atualizado com sucesso.");
    }

    static void findIdPorte() {
        Scanner sc = new Scanner(System.in);

        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("=== CONSULTA DE PORTE POR ID =======");
        System.out.println("Informe o ID para exibição:");
        Porte porte = porteDao.findById(sc.nextInt());
        if (porte != null) {
            System.out.println(porte);
        } else {
            System.out.println("Porte não encontrado.");
        }
    }

    static void findAllPorte() {
        PorteDao porteDao = DaoFactory.createPorteDao();
        System.out.println("\n=== LISTAGEM DE TODOS OS PORTES ===");
        List<Porte> list = porteDao.findAll();
        if (list.isEmpty()) {
            System.out.println("Não foram encontrados registros.");
        } else {
            for (Porte porte : list) {
                System.out.println(porte);
            }
        }
    }

    static void insertPorte() {
        Scanner sc = new Scanner(System.in);
        PorteDao porteDao = DaoFactory.createPorteDao();
        System.out.println("\n=== INSERÇÃO DE PORTE =======");
        System.out.println("Digite o código:");
        int cod = Integer.parseInt(sc.next());
        System.out.println("Digite a descrição:");
        sc.nextLine();
        String desc = sc.nextLine();
        Porte newPorte = new Porte(cod, desc);
        porteDao.insert(newPorte);
        System.out.println("Inserted! New id: " + newPorte.getId_Porte());
    }

    static void deletePorte() {
        Scanner sc = new Scanner(System.in);

        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int cod = Integer.parseInt(sc.next());
        porteDao.deleteById(cod);
        System.out.println("Delete completed");

    }

    static void updateEndereco() {
        Scanner sc = new Scanner(System.in);
        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
        System.out.println("\n=== TEST 4: update =======");
        System.out.println("Informe o ID que deseja atualizar:");
        int id = sc.nextInt();
        sc.nextLine(); // Consuma a nova linha após a entrada do número
        Endereco endereco = enderecoDao.findById(id);

        System.out.println("Digite a Cidade:");
        endereco.setCidade(sc.nextLine());

        System.out.println("Digite o Numero:");
        endereco.setNumero(sc.nextLine());

        System.out.println("Digite o Estado:");
        endereco.setEstado(sc.nextLine());

        System.out.println("Digite o Bairro:");
        endereco.setBairro(sc.nextLine());

        System.out.println("Digite o CEP:");
        endereco.setCep(sc.nextLine());

        System.out.println("Digite o Complemento:");
        endereco.setComplemento(sc.nextLine());

        enderecoDao.update(endereco);
        System.out.println("Update completed");

    }

    static void findIdEndereco() {
        Scanner sc = new Scanner(System.in);

        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("=== TEST 1: findById =======");
        System.out.println("informe o id a ser exibido");
        Endereco endereco = enderecoDao.findById(sc.nextInt());
        System.out.println(endereco);


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
        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== TEST 3: insert =======");
        System.out.println("Digite a Cidade: ");
        String cidade = sc.nextLine();
        System.out.println("Digite o Numero: ");
        String numero = sc.nextLine(); // Leia o número diretamente

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
    }

    static void deleteEndereco(){
        Scanner sc = new Scanner(System.in);

        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        enderecoDao.deleteById(id);
        System.out.println("Delete completed");

    }


    static void updateEmpresa() {
        Scanner sc = new Scanner(System.in);
        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();
        System.out.println("\n=== TEST 4: update =======");
        System.out.println("Informe o ID que deseja atualizar:");
        int id = sc.nextInt();
        sc.nextLine(); // Consuma a nova linha após a entrada do número
        Empresa empresa = empresaDao.findById(id);

        System.out.println("Digite o Email:");
        empresa.setEmail(sc.nextLine());

        System.out.println("Digite a Razão Social:");
        empresa.setRazao_social(sc.nextLine());

        System.out.println("Digite o Nome Fantasia:");
        empresa.setNome_fantasia(sc.nextLine());

        System.out.println("Digite o CNPJ:");
        empresa.setCnpj(sc.nextLine());

        System.out.println("Digite a Quantidade de Funcionários:");
        empresa.setQtd_funcionarios(sc.nextInt());
        sc.nextLine(); // Consuma a nova linha após a entrada do número

        System.out.println("Digite o Telefone:");
        empresa.setTelefone(sc.nextLine());

        System.out.println("Digite a Pontuação:");
        empresa.setPontuacao(sc.nextInt());

        empresaDao.update(empresa);
        System.out.println("Update completed");
    }

    static void findIdEmpresa() {
        Scanner sc = new Scanner(System.in);

        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("=== TEST 1: findById =======");
        System.out.println("informe o id a ser exibido");
        Empresa empresa = empresaDao.findById(sc.nextInt());
        System.out.println(empresa);
    }
    static void findAllEmpresa(){
        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("\n=== TEST 2: findAll =======");
        List<Empresa> list = empresaDao.findAll();
        for (Empresa empresa : list) {
            System.out.println(empresa);
        }

    }

    static void insertEmpresa(){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("\n=== TEST 3: insert =======");
        System.out.println("Digite a Email: ");
        String email = sc.nextLine();
        System.out.println("Digite a Razao Social: ");
        String razao_social = sc.nextLine();
        System.out.println("Digite o Nome Fantasia: ");
        String nome_fantasia = sc.nextLine();
        System.out.println("Digite o CNPJ");
        String cnpj = sc.nextLine();
        System.out.println("Digite a Quantidade de Funcionarios");
        int qtd_funcionarios = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o Telefone");
        String telefone = sc.nextLine();
        System.out.println("Digite a Pontuacao");
        int pontuacao = sc.nextInt();
        sc.nextLine();

        Empresa newEmpresa = new Empresa(null,email,razao_social,nome_fantasia,cnpj,qtd_funcionarios, telefone, pontuacao);
        empresaDao.insert(newEmpresa);

        System.out.println("Inserted! New id: " + newEmpresa.getId_Empresa());
    }

    static void deleteEmpresa(){
        Scanner sc = new Scanner(System.in);

        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        empresaDao.deleteById(id);
        System.out.println("Delete completed");
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

        System.out.println("=== Inserção de Colaborador ===");
        System.out.println("Digite o Nome:");
        String nome = sc.nextLine(); // Lê toda a linha, incluindo espaços
        System.out.println("Digite o Telefone:");
        String telefone = sc.nextLine();
        System.out.println("Digite o Email:");
        String email = sc.nextLine();
        System.out.println("Digite a Função:");
        String funcao = sc.nextLine();
        System.out.println("Digite o Setor:");
        String setor = sc.nextLine();
        System.out.println("O Colaborador é Admin? (Sim ou Não):");
        boolean isAdmin = sc.nextLine().trim().equalsIgnoreCase("sim"); // Assume "sim" como verdadeiro, todo o resto como falso

        Colaborador newColaborador = new Colaborador(nome, telefone, email, funcao, setor, isAdmin);

        colaboradorDao.insert(newColaborador);
        System.out.println("Colaborador inserido com sucesso.");
    }


    static void deleteColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Delete Colaborador ===");
        System.out.println("Enter the ID of the Colaborador to delete:");
        int id = sc.nextInt();
        colaboradorDao.deleteById(id);

    }

    static void findIdColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Find Colaborador by ID ===");
        System.out.println("Enter the ID of the Colaborador to find:");
        Colaborador colaborador = colaboradorDao.findById(sc.nextInt());
        System.out.println("Colaborador: ");
        System.out.println(colaborador);



    }

    static void updateRamo(){
        Scanner sc = new Scanner(System.in);
        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("\n=== TEST 4: update =======");
        System.out.println("informe o id que deseja atualizar");
        Ramo ramo = ramoDao.findById(sc.nextInt());
        System.out.println("digite o codigo:");
        int cod= Integer.parseInt(sc.next());
        System.out.println("digite a descricao:");
        sc.nextLine();// para limpar o buffer e liberar a proxima pergunta
        String desc= sc.nextLine();
        ramo.setId_Ramo(cod);
        ramo.setNome(desc);
        ramoDao.update(ramo);
        System.out.println("Update completed");


    }

    static void findIdRamo(){
        Scanner sc = new Scanner(System.in);

        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("=== TEST 1: findById =======");
        System.out.println("informe o id a ser exibido");
        Ramo dep = ramoDao.findById(sc.nextInt());
        System.out.println(dep);


    }

    static void findAllRamo(){
        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("\n=== TEST 2: findAll =======");
        List<Ramo> list = ramoDao.findAll();
        for (Ramo d : list) {
            System.out.println(d);
        }

    }

    static void insertRamo(){
        Scanner sc = new Scanner(System.in);

        RamoDao ramoDao = DaoFactory.createRamoDao();
        System.out.println("\n=== TEST 3: insert =======");
        System.out.println("digite o codigo");
        int cod = Integer.parseInt(sc.next());
        System.out.println("digite a descricao");
        sc.nextLine();
        String desc = sc.nextLine();
        Ramo NewRamo = new Ramo(cod,desc);
        ramoDao.insert(NewRamo);
        System.out.println("Inserted! New id: " + NewRamo.getId_Ramo());

    }

    static void deleteRamo(){
        Scanner sc = new Scanner(System.in);

        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int cod= Integer.parseInt(sc.next());
        ramoDao.deleteById(cod);
        System.out.println("Delete completed");
    }

}