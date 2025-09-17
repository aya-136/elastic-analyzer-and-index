package org.example.analyzer.processors.tokenizers;

import org.example.analyzer.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StandardTokenizer implements TokenizerProcess {
    private static final Pattern STANDARD_PATTERN = Pattern.compile("\\p{L}[\\p{L}\\p{Mn}\\p{Nd}_']*");

    @Override
    public List<Token> tokenize(String text){
        List<Token> tokens = new ArrayList<>();
        java.util.regex.Matcher matcher = STANDARD_PATTERN.matcher(text);
        while (matcher.find()) {
            tokens.add(new Token(matcher.group()));
        }
        return tokens;
    }
}
