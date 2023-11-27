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
   public static void updatePorte() {
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

    public static void findIdPorte() {
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

   public static void findAllPorte() {
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

   public static void insertPorte() {
        Scanner sc = new Scanner(System.in);
        PorteDao porteDao = DaoFactory.createPorteDao();
        System.out.println("\n=== INSERÇÃO DE PORTE =======");
//        System.out.println("Digite o código:");
//        int cod = Integer.parseInt(sc.next());
        System.out.println("Digite a descrição:");
        sc.nextLine();
        String desc = sc.nextLine();
        Porte newPorte = new Porte(desc);
        porteDao.insert(newPorte);
        System.out.println("Porte inserido com sucesso!! ID: " + newPorte.getId_Porte());
    }

   public static void deletePorte() {
        Scanner sc = new Scanner(System.in);

        PorteDao porteDao = DaoFactory.createPorteDao();

        System.out.println("\n=== DELETAR PORTE =======");
        System.out.print("Digite o ID para Deletar: ");
        int cod = Integer.parseInt(sc.next());
        porteDao.deleteById(cod);
        System.out.println("Deletado com sucesso!!");

    }

   public static void updateEndereco() {
        Scanner sc = new Scanner(System.in);
        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
        System.out.println("\n=== Atualizar =======");
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
        System.out.println("Atualização Completa!!");

    }

    public static void findIdEndereco() {
        Scanner sc = new Scanner(System.in);

        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("=== BUSCA POR ID =======");
        System.out.println("Informe o id a ser exibido:");
        Endereco endereco = enderecoDao.findById(sc.nextInt());
        System.out.println(endereco);


    }

    public static void findAllEndereco() {
        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== LISTA DE ENDERECOS =======");
        List<Endereco> list = enderecoDao.findAll();
        for (Endereco endereco : list) {
            System.out.println(endereco);
        }

    }

    public static void insertEndereco() {
        Scanner sc = new Scanner(System.in);
        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== CADASTRAR ENDERECO =======");
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

        System.out.println("Endereco inserido com Sucesso!!!");
    }

    public static void deleteEndereco(){
        Scanner sc = new Scanner(System.in);

        EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

        System.out.println("\n=== DELETE ENDERECO =======");
        System.out.print("Digite o id do Endereco: ");
        int id = sc.nextInt();
        enderecoDao.deleteById(id);
        System.out.println("Endereco Removido!!");

    }


    public static void updateEmpresa() {
        Scanner sc = new Scanner(System.in);
        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();
        System.out.println("\n=== Atualizar Empresa =======");
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
        System.out.println("Atualizado com sucesso!!");
    }

    public static void findIdEmpresa() {
        Scanner sc = new Scanner(System.in);

        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("=== Busca de Empresa por ID =======");
        System.out.println("Informe o id a ser exibido");
        Empresa empresa = empresaDao.findById(sc.nextInt());
        System.out.println(empresa);
    }
    public static void findAllEmpresa(){
        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("\n=== Lista de Empresas =======");
        List<Empresa> list = empresaDao.findAll();
        for (Empresa empresa : list) {
            System.out.println(empresa);
        }

    }

    public static void insertEmpresa(){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("\n=== Cadastrar Empresa =======");
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

        System.out.println("Cadastrado com sucesso!!");
    }

    public static void deleteEmpresa(){
        Scanner sc = new Scanner(System.in);

        EmpresaDao empresaDao = DaoFactory.createEmpresaDao();

        System.out.println("\n=== Remover Empresa =======");
        System.out.print("Digite o id da empresa: ");
        int id = sc.nextInt();
        empresaDao.deleteById(id);
        System.out.println("Removido com Sucesso!!");
    }

    public static void updateColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Atualizar Colaborador ===");
        System.out.println("Digite o ID do colaborador:");
        int id = sc.nextInt();
        Colaborador colaborador = colaboradorDao.findById(id);

        if (colaborador != null) {
            System.out.println("Digite o nome:");
            sc.nextLine(); // Clear the buffer
            String nome = sc.nextLine();
            System.out.println("Digite o telefone(Apenas numeros):");
            String telefone = sc.next();
            System.out.println("Digite o Email:");
            String email = sc.next();
            System.out.println("Digite sua Funcao:");
            String funcao = sc.next();
            System.out.println("Digite seu Setor:");
            String setor = sc.next();
            System.out.println("O Colaborador é Admin? (Sim ou Não):");
            boolean isAdmin = sc.next().trim().equalsIgnoreCase("sim");

            colaborador.setNome(nome);
            colaborador.setTelefone(telefone);
            colaborador.setEmail(email);
            colaborador.setFuncao(funcao);
            colaborador.setSetor(setor);
            colaborador.setAdmin(isAdmin);

            colaboradorDao.update(colaborador);
            System.out.println("Colaborador atualizado com Sucesso!!.");
        } else {
            System.out.println("Colaborador não existe!!");
        }
    }

    public static void findAllColaborador() {
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Lista de Colaboradores ===");
        List<Colaborador> colaboradores = colaboradorDao.findAll();
        for (Colaborador colaborador : colaboradores) {
            System.out.println(colaborador);
        }
    }

    public static void insertColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Inserção de Colaborador ===");
        System.out.println("Digite o Nome:");
        String nome = sc.nextLine();
        System.out.println("Digite o Telefone (Apenas numeros)");
        String telefone = sc.nextLine();
        System.out.println("Digite o Email:");
        String email = sc.nextLine();
        System.out.println("Digite a Função:");
        String funcao = sc.nextLine();
        System.out.println("Digite o Setor:");
        String setor = sc.nextLine();
        System.out.println("O Colaborador é Admin? (Sim ou Não):");
        boolean isAdmin = sc.nextLine().trim().equalsIgnoreCase("sim");

        Colaborador newColaborador = new Colaborador(nome, telefone, email, funcao, setor, isAdmin);

        colaboradorDao.insert(newColaborador);
        System.out.println("Colaborador inserido com sucesso.");
    }


    public static void deleteColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Remover Colaborador ===");
        System.out.println("Digite o ID do Colaborador para deletar!!!:");
        int id = sc.nextInt();
        colaboradorDao.deleteById(id);
        System.out.println("Colaborador deletado com sucesso!!");

    }

    public static void findIdColaborador() {
        Scanner sc = new Scanner(System.in);
        ColaboradorDao colaboradorDao = DaoFactory.createColaboradorDao();

        System.out.println("=== Buscar Colaborador Pelo ID ===");
        System.out.println("Digite o ID do colaborador:");
        Colaborador colaborador = colaboradorDao.findById(sc.nextInt());
        System.out.println("Colaborador: ");
        System.out.println(colaborador);



    }

    public static void updateRamo(){
        Scanner sc = new Scanner(System.in);
        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("\n=== Atualizar Ramo =======");
        System.out.println("informe o id que deseja atualizar");
        Ramo ramo = ramoDao.findById(sc.nextInt());
        System.out.println("digite a descricao:");
        sc.nextLine();// para limpar o buffer e liberar a proxima pergunta
        String desc= sc.nextLine();
        ramo.setNome(desc);
        ramoDao.update(ramo);
        System.out.println("Ramo Atualizado com Sucesso");
    }

    public static void findIdRamo(){
        Scanner sc = new Scanner(System.in);

        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("=== Buscar Ramo pelo ID =======");
        System.out.println("informe o id a ser exibido");
        Ramo dep = ramoDao.findById(sc.nextInt());
        System.out.println(dep);


    }

    public static void findAllRamo(){
        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("\n=== Lista de Ramos =======");
        List<Ramo> list = ramoDao.findAll();
        for (Ramo d : list) {
            System.out.println(d);
        }

    }

    public static void insertRamo(){
        Scanner sc = new Scanner(System.in);

        RamoDao ramoDao = DaoFactory.createRamoDao();
        System.out.println("\n=== Inserir Ramo =======");
        System.out.println("digite a descricao");
        String desc = sc.nextLine();
        Ramo NewRamo = new Ramo(desc);
        ramoDao.insert(NewRamo);
        System.out.println("Ramo Inserido com Sucesso!!");

    }

    public static void deleteRamo(){
        Scanner sc = new Scanner(System.in);

        RamoDao ramoDao = DaoFactory.createRamoDao();

        System.out.println("\n=== Remover Ramo =======");
        System.out.print("Digite o ID do Ramo: ");
        int cod= Integer.parseInt(sc.next());
        ramoDao.deleteById(cod);
        System.out.println("Ramo deletado com Sucesso!!");
    }

}