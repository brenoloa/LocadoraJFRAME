import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela {
    Frota[] carros = new Frota[5];
    boolean sistema = false;

    public boolean getSistema() {
        return sistema;
    }

    public void setSistema(boolean sistema) {
        this.sistema = sistema;
    }

    JComboBox<String> ComboCarros;
    JTextField texto;

    public Tela() {
        carros[0] = new Frota("Onix", "Chevrolet", "HSD-3413", 2020, 24053);
        carros[1] = new Frota("Civic", "Honda", "ABC-1234", 2018, 54320);
        carros[2] = new Frota("Corolla", "Toyota", "XYZ-9876", 2021, 15230);
        carros[3] = new Frota("Gol", "Volkswagen", "DEF-5678", 2019, 32987);
        carros[4] = new Frota("Fiesta", "Ford", "GHI-9012", 2017, 47890);

        JFrame tela = new JFrame("janela");
        tela.setSize(300, 500);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tela.setLayout(null);

        String[] nomeCarros = new String[carros.length];

        for (int i = 0; i < carros.length; i++) {
            nomeCarros[i] = carros[i].getModelo();
        }

        ComboCarros = new JComboBox<>(nomeCarros);
        ComboCarros.setBounds(10, 10, 150, 30);
        tela.add(ComboCarros);

        JButton botao1 = new JButton("PEGAR");
        botao1.setFont(new Font("Arial", Font.BOLD, 20));
        botao1.setBounds(10, 60, 150, 50);
        botao1.setForeground(new Color(255, 255, 255));
        botao1.setBackground(new Color(255, 0, 0));

        JButton botao2 = new JButton("DEVOLVER");
        botao2.setFont(new Font("Arial", Font.BOLD, 20));
        botao2.setBounds(10, 130, 150, 50);
        botao2.setForeground(new Color(255, 255, 255));
        botao2.setBackground(new Color(255, 0, 0));

        tela.add(botao1);
        tela.add(botao2);

        // Campo de texto que é possível usar como input
        texto = new JTextField();
        texto.setBounds(10, 290, 268, 70);
        texto.setFont(new Font("Arial", Font.BOLD, 22));
        tela.add(texto);

        // Label de display
        JLabel label = new JLabel("DISPLAY DE COMANDOS");
        label.setBounds(10, 266, 200, 30);

        JLabel label2 = new JLabel("SELECIONE O CARRO");
        label2.setBounds(160, 8, 200, 30);

        tela.add(label);
        tela.add(label2);

        JCheckBox checkbox = new JCheckBox("ATIVAR SISTEMA");
        checkbox.setBounds(10, 400, 300, 40);
        checkbox.setSelected(false);
        tela.add(checkbox);

        // Adiciona ActionListeners para os botões
        checkbox.addActionListener(this::ativar);
        botao1.addActionListener(this::pegarCarro); // Adiciona ação para pegar o carro
        botao2.addActionListener(this::devolverCarro); // Adiciona ação para devolver o carro

        tela.setVisible(true);
    }

    private Frota getCarroSelecionado() {
        int index = ComboCarros.getSelectedIndex();
        return carros[index];
    }

    // Ação para ativar/desativar o sistema
    private void ativar(ActionEvent e) {
        setSistema(!getSistema()); // Inverte o estado do sistema
        System.out.println("SISTEMA : " + getSistema());
    }

    // Ação ao clicar no botão "PEGAR"
    private void pegarCarro(ActionEvent e) {
        if (getSistema()) {
            Frota carroSelecionado = getCarroSelecionado();
            texto.setText(carroSelecionado.getModelo() + " Alugado");
            System.out.println(carroSelecionado.getModelo() + " Alugado");
        } else {
            texto.setText("SISTEMA OFFLINE.");
        }
    }

    // Ação ao clicar no botão "DEVOLVER"
    private void devolverCarro(ActionEvent e) {
        if (getSistema()) {
            Frota carroSelecionado = getCarroSelecionado();
            texto.setText(carroSelecionado.getModelo() + " Devolvido");
            System.out.println(carroSelecionado.getModelo() + " Devolvido");
        } else {
            texto.setText("SISTEMA OFFLINE.");
        }
    }
}
