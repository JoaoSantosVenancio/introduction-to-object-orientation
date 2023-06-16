public class IdadeNulaException extends RuntimeException{
    @Override
    public String getMessage() {
        return ("Idade não pode ser negativa");
    }
}