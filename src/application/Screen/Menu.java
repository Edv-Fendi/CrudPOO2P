package application.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import application.Funcoes;
import model.entities.Colaborador;

public class Menu extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;
    private JButton ColaboradorButton;
    private JButton PorteButton;
    private JButton EnderecoButton;
    private JButton RamoButton;
    private JButton EmpresaButton;


    public Menu() {
        setTitle("Menu Gráfico");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Crie os painéis para cada opção do menu
        JPanel menuColaborador = createMenuColaborador();
        JPanel menuPorte = createMenuPortePanel();
        JPanel menuEnderecoPanel = createMenuEnderecoPanel();
        JPanel menuRamoPanel = createMenuRamoPanel();
        JPanel menuEmpresa = createMenuEmpresa();


        // Adicione os painéis ao "cards" com nomes para identificá-los
        cards.add(menuColaborador, "MenuColaborador");
        cards.add(menuPorte, "menuPorte");
        cards.add(menuEnderecoPanel, "menuEndereco");
        cards.add(menuRamoPanel, "menuRamo");
        cards.add(menuEmpresa, "menuEmpresa");


        add(cards);

// Crie botões para selecionar as opções do menu principal
        ColaboradorButton = new JButton("Colaborador");
        PorteButton = new JButton("Porte");
        EnderecoButton = new JButton("Endereco");
        RamoButton = new JButton("Ramo");
        EmpresaButton = new JButton("Empresa");


// Associe os botões aos métodos correspondentes
        ColaboradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "MenuColaborador");

            }
        });
        PorteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "menuPorte");

            }
        });
        EnderecoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "menuEndereco");

            }
        });
        RamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "menuRamo");

            }
        });
        EmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "menuEmpresa");

            }
        });

// Adicione os botões do menu principal
        JPanel menuPrincipalPanel = new JPanel();
        menuPrincipalPanel.add(ColaboradorButton);
        menuPrincipalPanel.add(PorteButton);
        menuPrincipalPanel.add(EnderecoButton);
        menuPrincipalPanel.add(RamoButton);
        menuPrincipalPanel.add(EmpresaButton);

        add(menuPrincipalPanel, BorderLayout.NORTH);

        setVisible(true);
    }

        private JPanel createMenuColaborador() {
            JPanel panel = new JPanel();

            addColaboratorButtons(panel);
            return panel;
        }
    private JPanel createMenuPortePanel() {
        JPanel panel = new JPanel();

        addPorteButtons(panel);
        return panel;
    }
    private JPanel createMenuEnderecoPanel() {
        JPanel panel = new JPanel();

        addEnderecoButtons(panel);
        return panel;
    }
    private JPanel createMenuRamoPanel() {
        JPanel panel = new JPanel();

        addRamoButtons(panel);
        return panel;
    }
    private JPanel createMenuEmpresa() {
        JPanel panel = new JPanel();

        addEmpresaButtons(panel);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu();
        });
    }

    private void addColaboratorButtons(JPanel menuColaborador) {
        JButton cadastrarColaborador = new JButton("Cadastrar Colaborador");
        JButton findAllColaborador = new JButton("Exibir Todos Colaborador");
        JButton findIDColaborador = new JButton("Exibir por Colaborador por ID");
        JButton updateColaborador = new JButton("Atualizar Colaborador");
        JButton deleteColaborador = new JButton("Deletar Colaborador");

        // Associe esses botões aos métodos correspondentes
        cadastrarColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarColaborador();
            }
        });

        findAllColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosColaborador();
            }
        });

        findIDColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirColaboradorPeloId();
            }
        });

        updateColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarColaborador();
            }
        });

        deleteColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarColaborador();
            }
        });

        menuColaborador.add(cadastrarColaborador);
        menuColaborador.add(findAllColaborador);
        menuColaborador.add(findIDColaborador);
        menuColaborador.add(updateColaborador);
        menuColaborador.add(deleteColaborador);
    }
    private void addPorteButtons(JPanel menuPortePanel) {
        JButton cadastrarPorte = new JButton("Cadastrar Porte");
        JButton findAllPorte = new JButton("Exibir Todos Portes");
        JButton findIDPorte = new JButton("Exibir Porte por ID");
        JButton updatePorte = new JButton("Atualizar Porte");
        JButton deletePorte = new JButton("Deletar Porte");

        // Associe esses botões aos métodos correspondentes
        cadastrarPorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPorte();
            }
        });

        findAllPorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosPortes();
            }
        });

        findIDPorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPortePeloId();
            }
        });

        updatePorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarPorte();
            }
        });

        deletePorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarPorte();
            }
        });

        menuPortePanel.add(cadastrarPorte);
        menuPortePanel.add(findAllPorte);
        menuPortePanel.add(findIDPorte);
        menuPortePanel.add(updatePorte);
        menuPortePanel.add(deletePorte);
    }
    private void addEnderecoButtons(JPanel menuEnderecoPanel) {
        JButton cadastrarEndereco = new JButton("Cadastrar Endereco");
        JButton findAllEndereco = new JButton("Exibir Todos Endereco");
        JButton findIDEndereco = new JButton("Exibir Endereco por ID");
        JButton updateEndereco = new JButton("Atualizar Endereco");
        JButton deleteEndereco = new JButton("Deletar Endereco");

        // Associe esses botões aos métodos correspondentes
        cadastrarEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEndereco();
            }
        });

        findAllEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosEndereco();
            }
        });

        findIDEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirEnderecoPeloId();
            }
        });

        updateEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEndereco();
            }
        });

        deleteEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarEndereco();
            }
        });

        menuEnderecoPanel.add(cadastrarEndereco);
        menuEnderecoPanel.add(findAllEndereco);
        menuEnderecoPanel.add(findIDEndereco);
        menuEnderecoPanel.add(updateEndereco);
        menuEnderecoPanel.add(deleteEndereco);

    }private void addRamoButtons(JPanel menuRamoPanel) {
        JButton cadastrarRamo = new JButton("Cadastrar Ramo");
        JButton findAllRamo = new JButton("Exibir Todos Ramo");
        JButton findIDRamo = new JButton("Exibir Ramo por ID");
        JButton updateRamo = new JButton("Atualizar Ramo");
        JButton deleteRamo = new JButton("Deletar Ramo");

        // Associe esses botões aos métodos correspondentes
        cadastrarRamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarRamo();
            }
        });

        findAllRamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosRamo();
            }
        });

        findIDRamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirRamoPeloId();
            }
        });

        updateRamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarRamo();
            }
        });

        deleteRamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarRamo();
            }
        });

        menuRamoPanel.add(cadastrarRamo);
        menuRamoPanel.add(findAllRamo);
        menuRamoPanel.add(findIDRamo);
        menuRamoPanel.add(updateRamo);
        menuRamoPanel.add(deleteRamo);
    }

    private void addEmpresaButtons(JPanel menuEmpresaPanel) {
        JButton cadastrarEmpresa = new JButton("Cadastrar Empresa");
        JButton findAllEmpresa = new JButton("Exibir Todas as Empresas");
        JButton findIDEmpresa = new JButton("Exibir Empresa por ID");
        JButton updateEmpresa = new JButton("Atualizar Empresa");
        JButton deleteEmpresa = new JButton("Deletar Empresa");

        // Associe esses botões aos métodos correspondentes
        cadastrarEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEmpresa();
            }
        });

        findAllEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTodosEmpresa();
            }
        });

        findIDEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirEmpresaPeloId();
            }
        });

        updateEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEmpresa();
            }
        });

        deleteEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarEmpresa();
            }
        });

        menuEmpresaPanel.add(cadastrarEmpresa);
        menuEmpresaPanel.add(findAllEmpresa);
        menuEmpresaPanel.add(findIDEmpresa);
        menuEmpresaPanel.add(updateEmpresa);
        menuEmpresaPanel.add(deleteEmpresa);
    }

    private void cadastrarColaborador() {
        Funcoes.insertColaborador();
    }

    private void exibirTodosColaborador() {
        Funcoes.findAllColaborador();
    }

    private void exibirColaboradorPeloId() {
        Funcoes.findIdColaborador();
    }

    private void atualizarColaborador() {
        Funcoes.updateColaborador();
    }

    private void deletarColaborador() {
        Funcoes.deleteColaborador();
    }

    private void cadastrarPorte() {
        Funcoes.insertPorte();
    }

    private void exibirTodosPortes() {
        Funcoes.findAllPorte();
    }

    private void exibirPortePeloId() {
        Funcoes.findIdPorte();
    }

    private void atualizarPorte() {
        Funcoes.updatePorte();
    }

    private void deletarPorte() {
        Funcoes.deletePorte();
    }
    private void cadastrarEndereco() {
        Funcoes.insertEndereco();
    }

    private void exibirTodosEndereco() {
        Funcoes.findAllEndereco();
    }

    private void exibirEnderecoPeloId() {
        Funcoes.findIdEndereco();
    }

    private void atualizarEndereco() {
        Funcoes.updateEndereco();
    }

    private void deletarEndereco() {
        Funcoes.deleteEndereco();
    }
    private void cadastrarRamo() {
        Funcoes.insertRamo();
    }

    private void exibirTodosRamo() {
        Funcoes.findAllRamo();
    }

    private void exibirRamoPeloId() {
        Funcoes.findIdRamo();
    }

    private void atualizarRamo() {
        Funcoes.updateRamo();
    }

    private void deletarRamo() {
        Funcoes.deleteRamo();
    }

    private void cadastrarEmpresa(){ Funcoes.insertEmpresa();}
    private void exibirTodosEmpresa() { Funcoes.findAllEmpresa();}
    private void exibirEmpresaPeloId(){ Funcoes.findIdEmpresa();}
    private void atualizarEmpresa(){Funcoes.updateEmpresa();}
    private void deletarEmpresa(){Funcoes.deleteEmpresa();}

    }
