package br.ufsm.csi;

//Usei Delombok para gerar getter, setters, equals, hashcode e contructors
public class User {
    @Validate(message = "Nome inválido")
    @Lenght(min = 10, max = 25, message = "Tamanho de nome muito curto ou muito longo!")
    @NotNull(message = "NULO")
    private String name;
    @Validate(message = "Idade inválida!")
    @Min(value = 18, message = "O usuário deve ter no mínimo 18 anos")
    @Max(value = 60, message = "O usuário deve ter no máximo 60 anos")
    private Long age;

    public User(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return this.name;
    }

    public Long getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $age = this.getAge();
        result = result * PRIME + ($age == null ? 43 : $age.hashCode());
        return result;
    }

    public String toString() {
        return "User(name=" + this.getName() + ", age=" + this.getAge() + ")";
    }
}
