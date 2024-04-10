package br.ufsm.csi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User("luk", "12");

        Validator<User> validator = new Validator<>();

        try {
            validator.validate(user);
            System.out.println("Objeto válido");
        } catch (ValidationException ex) {
            System.out.println("Objeto inválido");
            ex.printStackTrace();
        }
    }
}