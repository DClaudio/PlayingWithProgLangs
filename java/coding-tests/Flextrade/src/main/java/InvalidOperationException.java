/**
 * Created by claudio.david on 05/08/2015.
 */
public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String reason) {
        super(reason);
    }
}