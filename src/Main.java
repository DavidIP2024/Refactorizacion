public class Main {
    /**
     * Metodo para devolver la puntuación de tenis
     */
    public static String getScore(int m_score1, int m_score2) {
        if (m_score1 == m_score2) {
            return getEqualScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getAdvantageOrWin(m_score1, m_score2);
        } else {
            return getStandardScore(m_score1, m_score2);
        }
    }

    private static String getEqualScore(int score) {
        return switch (score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        };
    }

    private static String getAdvantageOrWin(int m_score1, int m_score2) {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private static String getStandardScore(int m_score1, int m_score2) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_score1;
            else {
                score.append("-");
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0 -> score.append("Love");
                case 1 -> score.append("Fifteen");
                case 2 -> score.append("Thirty");
                case 3 -> score.append("Forty");
            }
        }
        return score.toString();
    }
}