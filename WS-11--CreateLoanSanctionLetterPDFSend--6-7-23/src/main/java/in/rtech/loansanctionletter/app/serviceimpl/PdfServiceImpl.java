package in.rtech.loansanctionletter.app.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
<<<<<<< HEAD

import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.rtech.loansanctionletter.app.model.LoanApplication;
import in.rtech.loansanctionletter.app.model.SanctionDetails;
import in.rtech.loansanctionletter.app.repository.LoanRepository;
import in.rtech.loansanctionletter.app.repository.PdfRepository;
import in.rtech.loansanctionletter.app.service.LoanService;
import in.rtech.loansanctionletter.app.service.PdfService;

@Repository
public class PdfServiceImpl implements PdfService{

	@Autowired
	LoanService ls;

	@Override
	public ByteArrayInputStream createPdf(int loanId) {
		
		LoanApplication loanAppl = ls.getLoanAppDetail(loanId);
		
		String title="Loan Sanction Letter";
		
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String formatedDate=dateFormat.format(date);
		
		String to="Date: "+formatedDate+"\n To "+loanAppl.getCustFirstName()+" "+loanAppl.getCustMiddleName()+" "+loanAppl.getCustLastName();
		String sub="Sub: Details of Loan sactioned details.";
		String dear="Dear "+ loanAppl.getCustFirstName();
		String body="						Lorem Ipsum is simply dummy text of "
				+ "the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
				+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
		
		String loanApp="1) Loan Application Details:";
		String loanDetails="2) Loan Details:";
		String sanctionDetails="3) Loan Sanction Details:";
		
		String thanks="Thank you, \n regards CJC!";
		
		
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		
		Document doc=new Document();
		
//		PdfPTable table=new PdfPTable();
		
		PdfWriter.getInstance(doc, out);
		doc.open();
		
		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
		Paragraph titlePara=new Paragraph(title,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		doc.add(titlePara);
		
		Font toFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph toPara=new Paragraph(to,toFont);
		toPara.setSpacingBefore(20);
		doc.add(toPara);
		
		Font subFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph subPara=new Paragraph(sub,subFont);
		subPara.setAlignment(Element.ALIGN_CENTER);
		subPara.setSpacingBefore(20);
		doc.add(subPara);
		
		Font dearFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph dearPara=new Paragraph(dear,dearFont);
		dearPara.setSpacingBefore(20);
		doc.add(dearPara);
		
		Paragraph bodyPara=new Paragraph(body);
		doc.add(bodyPara);
		
//		-------------------Table 1) => Loan Application ------------------------
		Font loanAppFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph loanAppPara=new Paragraph(loanApp,loanAppFont);
		loanAppPara.setSpacingBefore(20);
		doc.add(loanAppPara);
		
		PdfPTable table=new PdfPTable(5);
		table.setWidths(new int[] {2,2,2,2,4});
		table.setWidthPercentage(100F);
		table.setSpacingBefore(20);
		
//		-------------------Cell-------------------------
		PdfPCell headCell=new PdfPCell();
			headCell.setPadding(7);
			//headCell.setPaddingBottom(7);
			headCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			headCell.setBackgroundColor(CMYKColor.RED);
			Font headCellFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			headCellFont.setColor(CMYKColor.WHITE);
			
//		-------------------Phrase-----------------------
		headCell.setPhrase(new Phrase("Loan Application Id",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer First Name",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer Middle Name",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer Last Name",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer Email Id",headCellFont));
		table.addCell(headCell);
		
		PdfPCell dataCell=new PdfPCell();
		dataCell.setPadding(7);
		dataCell.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		dataCell.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanAppId())));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustFirstName()));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustMiddleName()));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustLastName()));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustEmailId()));
		table.addCell(dataCell);
		
		doc.add(table);
		
//		-------------------Table 2) => Loan Details ------------------------
		Paragraph loanDetailsPara=new Paragraph(loanDetails,loanAppFont);
		loanDetailsPara.setSpacingBefore(20);
		doc.add(loanDetailsPara);
		
		PdfPTable table2=new PdfPTable(4);
		table2.setWidths(new int[] {2,3,3,3});
		table2.setWidthPercentage(100F);
		table2.setSpacingBefore(20);
		
//		-------------------Cell-------------------------
		PdfPCell headCell2=new PdfPCell();
			headCell2.setPadding(7);
			//headCell2.setPaddingBottom(7);
			headCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			headCell2.setBackgroundColor(CMYKColor.RED);
			Font headCellFont2=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			headCellFont2.setColor(CMYKColor.WHITE);
			
//		-------------------Phrase-----------------------
		headCell2.setPhrase(new Phrase("Loan Id",headCellFont2));
		table2.addCell(headCell2);
		headCell2.setPhrase(new Phrase("Loan Type",headCellFont2));
		table2.addCell(headCell2);
		headCell2.setPhrase(new Phrase("Loan Amount(INR)",headCellFont2));
		table2.addCell(headCell2);
		headCell2.setPhrase(new Phrase("Tenure(Years)",headCellFont2));
		table2.addCell(headCell2);
		
		PdfPCell dataCell2=new PdfPCell();
		dataCell2.setPadding(7);
		dataCell2.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		dataCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		dataCell2.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanDetails().getLoanId())));
		table2.addCell(dataCell2);
		dataCell2.setPhrase(new Phrase(loanAppl.getLoanDetails().getLoanType()));
		table2.addCell(dataCell2);
		dataCell2.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanDetails().getLoanAmount())));
		table2.addCell(dataCell2);
		dataCell2.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanDetails().getTenure())));
		table2.addCell(dataCell2);
		
		doc.add(table2);
		
//		-------------------Table 3) => Loan Sanction Details ------------------------
		Paragraph sanctionDetailsPara=new Paragraph(sanctionDetails,loanAppFont);
		sanctionDetailsPara.setSpacingBefore(20);
		doc.add(sanctionDetailsPara);
		
		PdfPTable table3=new PdfPTable(7);
		table3.setWidths(new int[] {2,3,3,3,3,3,3});
		table3.setWidthPercentage(100F);
		table3.setSpacingBefore(20);
		
//		-------------------Cell-------------------------
		PdfPCell headCell3=new PdfPCell();
			headCell3.setPadding(7);
			//headCell3.setPaddingBottom(7);
			headCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			headCell3.setBackgroundColor(CMYKColor.RED);
			Font headCellFont3=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			headCellFont3.setColor(CMYKColor.WHITE);
			
//		-------------------Phrase-----------------------
		headCell3.setPhrase(new Phrase("Loan Sanction Id",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Loan Type",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Sactioned Amount(INR)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Sactioned Tenure(Years)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("EMI(INR)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Total Amount(INR)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Total Interest Amount(INR)",headCellFont3));
		table3.addCell(headCell3);
		
		PdfPCell dataCell3=new PdfPCell();
		dataCell3.setPadding(7);
		dataCell3.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		dataCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getSanctionId())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(loanAppl.getSanctionDetails().getLoanType()));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getAmountSan())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getTenureSan())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getEmiSan())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getTotalAmount())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getTotalIntrest())));
		table3.addCell(dataCell3);
		
		doc.add(table3);
		
		Paragraph thankPara=new Paragraph(thanks,dearFont);
		thankPara.setSpacingBefore(20);
		thankPara.setAlignment(Element.ALIGN_RIGHT);
		doc.add(thankPara);
		
		doc.close();
=======
import java.util.Optional;

import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.rtech.loansanctionletter.app.model.LoanApplication;
import in.rtech.loansanctionletter.app.model.SanctionDetails;
import in.rtech.loansanctionletter.app.repository.LoanRepository;
import in.rtech.loansanctionletter.app.repository.PdfRepository;
import in.rtech.loansanctionletter.app.service.LoanService;
import in.rtech.loansanctionletter.app.service.PdfService;

@Service
public class PdfServiceImpl implements PdfService{

	@Autowired
	PdfRepository pr;

	@Override
	public ByteArrayInputStream createPdf(int loanId) {
		
		Optional<LoanApplication> ol = pr.findById(loanId);
		LoanApplication loanAppl=ol.get();
		
		String title="Loan Sanction Letter";
		
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String formatedDate=dateFormat.format(date);
		
		String to="Date: "+formatedDate+"\n To "+loanAppl.getCustFirstName()+" "+loanAppl.getCustMiddleName()+" "+loanAppl.getCustLastName();
		String sub="Sub: Details of Loan sactioned details.";
		String dear="Dear "+ loanAppl.getCustFirstName();
		String body="						Lorem Ipsum is simply dummy text of "
				+ "the printing and typesetting industry. "
				+ "Lorem Ipsum has \nbeen the industry's standard dummy text ever since the 1500s, "
				+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
		
		String loanApp="1) Loan Application Details:";
		String loanDetails="2) Loan Details:";
		String sanctionDetails="3) Loan Sanction Details:";
		
		String thanks="Thank you, \n regards CJC!";
		
		
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		
		Document doc=new Document();
		
//		PdfPTable table=new PdfPTable();
		
		PdfWriter.getInstance(doc, out);
		doc.open();
		
		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
		Paragraph titlePara=new Paragraph(title,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		doc.add(titlePara);
		
		Font toFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph toPara=new Paragraph(to,toFont);
		toPara.setSpacingBefore(20);
		doc.add(toPara);
		
		Font subFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph subPara=new Paragraph(sub,subFont);
		subPara.setAlignment(Element.ALIGN_CENTER);
		subPara.setSpacingBefore(20);
		doc.add(subPara);
		
		Font dearFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph dearPara=new Paragraph(dear,dearFont);
		dearPara.setSpacingBefore(20);
		doc.add(dearPara);
		
		Paragraph bodyPara=new Paragraph(body);
		doc.add(bodyPara);
		
//		-------------------Table 1) => Loan Application ------------------------
		Font loanAppFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph loanAppPara=new Paragraph(loanApp,loanAppFont);
		loanAppPara.setSpacingBefore(20);
		doc.add(loanAppPara);
		
		PdfPTable table=new PdfPTable(5);
		table.setWidths(new int[] {2,2,2,2,4});
		table.setWidthPercentage(100F);
		table.setSpacingBefore(20);
		
//		-------------------Cell-------------------------
		PdfPCell headCell=new PdfPCell();
			headCell.setPadding(7);
			//headCell.setPaddingBottom(7);
			headCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			headCell.setBackgroundColor(CMYKColor.RED);
			Font headCellFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			headCellFont.setColor(CMYKColor.WHITE);
			
//		-------------------Phrase-----------------------
		headCell.setPhrase(new Phrase("Loan Application Id",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer First Name",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer Middle Name",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer Last Name",headCellFont));
		table.addCell(headCell);
		headCell.setPhrase(new Phrase("Customer Email Id",headCellFont));
		table.addCell(headCell);
		
		PdfPCell dataCell=new PdfPCell();
		dataCell.setPadding(7);
		dataCell.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		dataCell.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanAppId())));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustFirstName()));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustMiddleName()));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustLastName()));
		table.addCell(dataCell);
		dataCell.setPhrase(new Phrase(loanAppl.getCustEmailId()));
		table.addCell(dataCell);
		
		doc.add(table);
		
//		-------------------Table 2) => Loan Details ------------------------
		Paragraph loanDetailsPara=new Paragraph(loanDetails,loanAppFont);
		loanDetailsPara.setSpacingBefore(20);
		doc.add(loanDetailsPara);
		
		PdfPTable table2=new PdfPTable(4);
		table2.setWidths(new int[] {2,3,3,3});
		table2.setWidthPercentage(100F);
		table2.setSpacingBefore(20);
		
//		-------------------Cell-------------------------
		PdfPCell headCell2=new PdfPCell();
			headCell2.setPadding(7);
			//headCell2.setPaddingBottom(7);
			headCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			headCell2.setBackgroundColor(CMYKColor.RED);
			Font headCellFont2=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			headCellFont2.setColor(CMYKColor.WHITE);
			
//		-------------------Phrase-----------------------
		headCell2.setPhrase(new Phrase("Loan Id",headCellFont2));
		table2.addCell(headCell2);
		headCell2.setPhrase(new Phrase("Loan Type",headCellFont2));
		table2.addCell(headCell2);
		headCell2.setPhrase(new Phrase("Loan Amount(INR)",headCellFont2));
		table2.addCell(headCell2);
		headCell2.setPhrase(new Phrase("Tenure(Years)",headCellFont2));
		table2.addCell(headCell2);
		
		PdfPCell dataCell2=new PdfPCell();
		dataCell2.setPadding(7);
		dataCell2.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		dataCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		dataCell2.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanDetails().getLoanId())));
		table2.addCell(dataCell2);
		dataCell2.setPhrase(new Phrase(loanAppl.getLoanDetails().getLoanType()));
		table2.addCell(dataCell2);
		dataCell2.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanDetails().getLoanAmount())));
		table2.addCell(dataCell2);
		dataCell2.setPhrase(new Phrase(String.valueOf(loanAppl.getLoanDetails().getTenure())));
		table2.addCell(dataCell2);
		
		doc.add(table2);
		
//		-------------------Table 3) => Loan Sanction Details ------------------------
		Paragraph sanctionDetailsPara=new Paragraph(sanctionDetails,loanAppFont);
		sanctionDetailsPara.setSpacingBefore(20);
		doc.add(sanctionDetailsPara);
		
		PdfPTable table3=new PdfPTable(7);
		table3.setWidths(new int[] {2,3,3,3,3,3,3});
		table3.setWidthPercentage(100F);
		table3.setSpacingBefore(20);
		
//		-------------------Cell-------------------------
		PdfPCell headCell3=new PdfPCell();
			headCell3.setPadding(7);
			//headCell3.setPaddingBottom(7);
			headCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			headCell3.setBackgroundColor(CMYKColor.RED);
			Font headCellFont3=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			headCellFont3.setColor(CMYKColor.WHITE);
			
//		-------------------Phrase-----------------------
		headCell3.setPhrase(new Phrase("Loan Sanction Id",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Loan Type",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Sactioned Amount(INR)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Sactioned Tenure(Years)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("EMI(INR)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Total Amount(INR)",headCellFont3));
		table3.addCell(headCell3);
		headCell3.setPhrase(new Phrase("Total Interest Amount(INR)",headCellFont3));
		table3.addCell(headCell3);
		
		PdfPCell dataCell3=new PdfPCell();
		dataCell3.setPadding(7);
		dataCell3.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		dataCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getSanctionId())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(loanAppl.getSanctionDetails().getLoanType()));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getAmountSan())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getTenureSan())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getEmiSan())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getTotalAmount())));
		table3.addCell(dataCell3);
		dataCell3.setPhrase(new Phrase(String.valueOf(loanAppl.getSanctionDetails().getTotalIntrest())));
		table3.addCell(dataCell3);
		
		doc.add(table3);
		
		Paragraph thankPara=new Paragraph(thanks,dearFont);
		thankPara.setSpacingBefore(20);
		thankPara.setAlignment(Element.ALIGN_RIGHT);
		doc.add(thankPara);
		
		doc.close();
		
		
		loanAppl.getSanctionDetails().setSanLetterPdf(out.toByteArray());
		pr.save(loanAppl);
>>>>>>> branch 'main' of https://github.com/RaviThorat/Hepo154.git
		
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	

}
