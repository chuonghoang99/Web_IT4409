package Interface;

import Model.Account;

public interface AccountInterface {
    public boolean checkSignIn(Account account);
    public boolean signUp(Account account);
    public int getRole(Account account);
}
