package com.sample;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class PessoaView {
    private PessoaService service = new PessoaService();

    public void Cadastrar() {
        PessoaModel pessoa = new PessoaModel();

        pessoa.setNome(JOptionPane.showInputDialog("Nome:"));
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento:");
        pessoa.setDataNascimento(LocalDate.parse(dataNascimento));
        pessoa.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Tipo:")));

        service.Salvar(pessoa);
    }

    public void Remover() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id:"));
        service.Remover(id);
    }

    public void Atualizar() {
        PessoaModel pessoa = new PessoaModel();

        pessoa.setId(Integer.parseInt(JOptionPane.showInputDialog("Id:")));
        pessoa.setNome(JOptionPane.showInputDialog("Nome:"));
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento:");
        pessoa.setDataNascimento(LocalDate.parse(dataNascimento));
        pessoa.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Tipo:")));

        service.Atualizar(pessoa);
    }

    public void Buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id:"));
        PessoaModel pessoa = service.Ler(id);

        JOptionPane.showMessageDialog(null, pessoa.toString());
    }
}
