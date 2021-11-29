package com.example.citizencafe;

import android.provider.MediaStore;

public class Problems {
    private String ProblemID = "";
    private String ProblrmTitle = "";
    private String ProblemStatement = "";

    public Problems() {

    }

    public Problems(String problemID, String problrmTitle, String problemStatement) {
        ProblemID = problemID;
        ProblrmTitle = problrmTitle;
        ProblemStatement = problemStatement;
    }

    public String getProblemID() {
        if(ProblemID.equals("")){return "nonefound";}else{ return ProblemID;}
    }

    public String getProblrmTitle() {
            if(ProblrmTitle.equals("")){return "nonefound";}else{ return ProblrmTitle;
            }
    }

    public String getProblemStatement() {
            if(ProblemStatement.equals("")){return "nonefound";}else{ return ProblemStatement;
            }
    }
}
