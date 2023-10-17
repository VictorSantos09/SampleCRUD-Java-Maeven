package com.sample;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        PessoaView view = new PessoaView();

        int opcao = 0;
        do {
            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog("1 - Cadastrar\n2 - Remover\n3 - Atualizar\n4 - Buscar\n5 - Sair"));
            switch (opcao) {
                case 1:
                    view.Cadastrar();
                    break;
                case 2:
                    view.Remover();
                    break;
                case 3:
                    view.Atualizar();
                    break;
                case 4:
                    view.Buscar();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }
}