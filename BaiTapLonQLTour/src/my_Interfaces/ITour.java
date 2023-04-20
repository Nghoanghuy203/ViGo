package my_Interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

import entities.Tour;

public interface ITour {
	public ArrayList<Tour> getDS();
	public Tour getTour(String id);
	public int count();
	public boolean themTour();
	public boolean xoaTour();
	public boolean suaTour();
	public ArrayList<Tour> timKiem(String diemDi, String diemDen, String ngayDi);
	public ArrayList<Tour> timKiem(String diemDi, String diemDen);
	ArrayList<Tour> timKiem(String noiDungTimKiem);
}
