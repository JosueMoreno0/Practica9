package txt.ito.poo;


import java.io.FileNotFoundException;
import java.util.Formatter;

public class escritorArchivo {

	private Formatter archivo;
	
	public escritorArchivo(String archivo) throws FileNotFoundException{
		this.archivo= new Formatter(archivo);
	}
	
	public  void writeByte(byte item) {
		this.archivo.format("%d ", item);
	}
	
	public void writeByteLn(byte item) {
		this.archivo.format("\n%d", item);
	}
	
	public void writeShort(short item) {
		this.archivo.format("%d ", item);
	}
	
	public void writeShortLn(short item) {
		this.archivo.format("\n%d", item);
	}
	
	public void writeInt(int item) {
		this.archivo.format("%d ",item);
	}
	
	public void writeIntLn(int item) {
		this.archivo.format("\n%d", item);
	}
	
	public void writeLong(long item) {
		this.archivo.format("%d ",item);
	}
	
	public void writeLongLn(long item) {
		this.archivo.format("\n%d", item);
	}
	
	public void writeString(String item) {
		this.archivo.format("%s ", item);
	}
	
	public void writeStringLn(String item) {
		this.archivo.format("\n%s", item);
	}
	
	public void writeFloat(float item) {
		this.archivo.format("%.2f ", item);
	}
	
	public void writeFloatLn(float item) {
		this.archivo.format("\n%f", item);
	}
	
	public void writeDouble(double item) {
		this.archivo.format("%f ", item);
	}
	
	public void writeDoubleLn(double item) {
		this.archivo.format("\n%f", item);
	}
	
	public void writeBoolean(boolean item) {
		this.archivo.format("%b ", item);
	}
	
	public void writeBooleanLn(boolean item) {
		this.archivo.format("\n%b", item);
	}
	
	
	
	public void close() {
		this.archivo.close();
	}
}