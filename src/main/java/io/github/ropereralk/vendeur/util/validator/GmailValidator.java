package io.github.ropereralk.vendeur.util.validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GmailValidator extends EmailValidator{


    private static final String GMAIL_REGEX = "^[A-Za-z0-9+_.-]+@gmail\\.com$";

     private static final Pattern pattern = Pattern.compile(GMAIL_REGEX);

    @Override
    public boolean validate(String email) {
        if (email == null) {
            return false;
        }

        // Match the input email with the regex pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
