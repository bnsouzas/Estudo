package br.com.alura.xstream.converter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.SingleValueConverter;

public class SimplesPrecoConverter implements SingleValueConverter {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean canConvert(Class type) {
		return type.isAssignableFrom(Double.class);
	}

	@Override
	public Object fromString(String preco) {
		Locale brasil = new Locale("pt","br");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(brasil);
		try {
			return Double.parseDouble(formatter.parse(preco).toString());
		} catch (ParseException e) {
			throw new ConversionException("Não foi possível converter: " + preco, e);
		}
	}

	@Override
	public String toString(Object preco) {
		Locale brasil = new Locale("pt","br");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(brasil);
		String formatado = formatter.format(preco);
		return formatado;
	}
	
}
