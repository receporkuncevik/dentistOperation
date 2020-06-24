
package entity;

public class Rontgen {
    private int id;
    private Hasta hasta;
    private String fileName;
    private String fileType;
    private String filePath;

    public Rontgen() {
    }

    public Rontgen(int id, Hasta hasta, String fileName, String fileType, String filePath) {
        this.id = id;
        this.hasta = hasta;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hasta getHasta() {
        if(this.hasta == null){
            this.hasta = new Hasta();
        }
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    
}
