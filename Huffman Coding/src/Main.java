public class Main {

    /** NOTE */
    /** DUE TO CARRIAGE RETURN AND NEWLINE BEING INDISTINGUISHABLE WHILE READING USING SCANNER */
    /** THE FINAL DECODED MESSAGE IS BEING CORRUPTED PERIODICALLY */

    /** SEE OUTPUT BELOW FOR CLARIFICATION */


    public static void main(String[] args) {
        Test();
        MobyDick();
        USConstitution();
        WarAndPeace();
    }

    /** file paths for test **/
    private final static String testPath = "./test.txt";
    private final static String testfreqPath = "./Test/testfreq.txt";
    private final static String testkeyPath = "./Test/testkey.ser";

    private final static String tesBitcodePath = "./Test/testkey.txt";
    private final static String testEncodedPath = "./Test/testEncoded.txt";
    private final static String testCompressedPath = "./Test/testCompressed.txt";
    private final static String testDecompressedPath = "./Test/testDecompressed.txt";
    private final static String testDecodedPath = "./Test/testDecoded.txt";


    /** file paths for Moby Dick **/
    private final static String filePath1 = "./MobyDick.txt";
    private final static String filefreqPath1 = "./Moby Dick/MobyDickFreq.txt";

    private final static String filekeyPath1 = "./Moby Dick/MobyDickkey.ser";

    private final static String fileBitcodePath1 = "./Moby Dick/MobyDickkey.txt";
    private final static String fileEncodedPath1 = "./Moby Dick/MobyDickEncoded.txt";

    private final static String fileCompressedPath1 = "./Moby Dick/MobyDickCompressed.txt";

    private final static String fileDecompressedPath1 = "./Moby Dick/MobyDickDecompressed.txt";
    private final static String fileDecodedPath1 = "./Moby Dick/MobyDickDecoded.txt";



    /** file paths for US Constitution **/
    private final static String filePath2 = "./USConstitution.txt";
    private final static String filefreqPath2 = "./US Constitution/USConstitutionFreq.txt";
    private final static String filekeyPath2 = "./US Constitution/USConstitutionkey.ser";

    private final static String fileBitcodePath2 = "./US Constitution/USConstitutionkey.txt";
    private final static String fileEncodedPath2 = "./US Constitution/USConstitutionEncoded.txt";
    private final static String fileCompressedPath2 = "./US Constitution/USConstitutionCompressed.txt";
    private final static String fileDecompressedPath2 = "./US Constitution/USConstitutionDecompressed.txt";
    private final static String fileDecodedPath2 = "./US Constitution/USConstitutionDecoded.txt";




    /** file paths for War And Peace **/
    private final static String filePath3 = "./WarAndPeace.txt";
    private final static String filefreqPath3 = "./War And Peace/WarAndPeaceFreq.txt";
    private final static String filekeyPath3 = "./War And Peace/WarAndPeacekey.ser";
    private final static String fileBitcodePath3 = "./War And Peace/WarAndPeacekey.txt";
    private final static String fileEncodedPath3 = "./War And Peace/WarAndPeaceEncoded.txt";
    private final static String fileCompressedPath3 = "./War And Peace/WarAndPeaceCompressed.txt";
    private final static String fileDecompressedPath3 = "./War And Peace/WarAndPeaceDecompressed.txt";
    private final static String fileDecodedPath3 = "./War And Peace/WarAndPeaceDecoded.txt";




    public static void Test(){


        FreqGenerator fq = new FreqGenerator(testPath, testfreqPath);

        HuffmanCodeGenerator hcg = new HuffmanCodeGenerator(testfreqPath, testkeyPath, tesBitcodePath);

        HuffmanEncoder he = new HuffmanEncoder(testPath, testEncodedPath, testkeyPath);

        HuffmanCompressor hc = new HuffmanCompressor(testEncodedPath, testCompressedPath);

        HuffmanDecompressor hd = new HuffmanDecompressor(testCompressedPath, testDecompressedPath);

        HuffmanDecoder hdcom = new HuffmanDecoder(testDecompressedPath, testDecodedPath, testkeyPath);
    }

    public static void MobyDick(){


        FreqGenerator fq = new FreqGenerator(filePath1, filefreqPath1);

        HuffmanCodeGenerator hcg = new HuffmanCodeGenerator(filefreqPath1, filekeyPath1, fileBitcodePath1);

        HuffmanEncoder he = new HuffmanEncoder(filePath1, fileEncodedPath1, filekeyPath1);

        HuffmanCompressor hc = new HuffmanCompressor(fileEncodedPath1, fileCompressedPath1);

        HuffmanDecompressor hdcom = new HuffmanDecompressor(fileCompressedPath1, fileDecompressedPath1);

        HuffmanDecoder hd = new HuffmanDecoder(fileDecompressedPath1, fileDecodedPath1, filekeyPath1);
    }

    public static void USConstitution(){


        FreqGenerator fq = new FreqGenerator(filePath2, filefreqPath2);

        HuffmanCodeGenerator hcg = new HuffmanCodeGenerator(filefreqPath2, filekeyPath2, fileBitcodePath2);

        HuffmanEncoder he = new HuffmanEncoder(filePath2, fileEncodedPath2, filekeyPath2);

        HuffmanCompressor hc = new HuffmanCompressor(fileEncodedPath2, fileCompressedPath2);

        HuffmanDecompressor hdcom = new HuffmanDecompressor(fileCompressedPath2, fileDecompressedPath2);

        HuffmanDecoder hd = new HuffmanDecoder(fileDecompressedPath2, fileDecodedPath2, filekeyPath2);
    }

    public static void WarAndPeace(){


        FreqGenerator fq = new FreqGenerator(filePath3, filefreqPath3);

        HuffmanCodeGenerator hcg = new HuffmanCodeGenerator(filefreqPath3, filekeyPath3, fileBitcodePath3);

        HuffmanEncoder he = new HuffmanEncoder(filePath3, fileEncodedPath3, filekeyPath3);

        HuffmanCompressor hc = new HuffmanCompressor(fileEncodedPath3, fileCompressedPath3);

        HuffmanDecompressor hdcom = new HuffmanDecompressor(fileCompressedPath3, fileDecompressedPath3);

        HuffmanDecoder hd = new HuffmanDecoder(fileDecompressedPath3, fileDecodedPath3, filekeyPath3);
    }
}