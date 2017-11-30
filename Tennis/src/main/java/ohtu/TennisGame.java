package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String scoreAsString(int score) {
        if (score == 1) {
            return "Fifteen";
        } else if (score == 2) {
            return "Thirty";
        } else if (score == 3) {
            return "Forty";
        } else {
            return "Love";
        }
    }

    public String getScore() {
        String score = "";
        if (m_score1 < 4 && m_score2 < 4) {
            if (m_score1 == 0 && m_score2 == 0) {
                return "Love-All";
            } else if (m_score1 == m_score2) {
                String score1 = scoreAsString(m_score1);
                return score1 + "-All";
            } else {
                String score1 = scoreAsString(m_score1);
                String score2 = scoreAsString(m_score2);
                return score1 + "-" + score2;
            }
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            if (m_score1 == 4 && m_score2 == 4) {
                return "Deuce";
            }
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) {
                score = "Advantage player1";
            } else if (minusResult == -1) {
                score = "Advantage player2";
            } else if (minusResult >= 2) {
                score = "Win for player1";
            } else {
                score = "Win for player2";
            }
        }
        return score;
    }
}
