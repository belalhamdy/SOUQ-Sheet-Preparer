public abstract class Profile {
    String batchPath, sampleExcel, outputPath;

    public Profile(String batchPath, String sampleExcel, String outputPath) {
        this.batchPath = batchPath;
        this.sampleExcel = sampleExcel;
        this.outputPath = outputPath;
    }

    public abstract void run();
}
