package FactoryMethodPatternExample;

public class TestClass {
    public static void main(String[] args){

        DocumentFactory wFactory=new WordFactory();
        Document word=wFactory.createDocument();
        word.open();

        DocumentFactory pFactory=new PdfFactory();
        Document pdf=pFactory.createDocument();
        pdf.open();

        DocumentFactory eFactory=new ExcelFactory();
        Document excel=eFactory.createDocument();
        excel.open();
    }
}