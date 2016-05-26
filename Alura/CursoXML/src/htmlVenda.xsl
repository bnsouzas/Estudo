<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="venda">
		<h3>Venda</h3>
		<p>Forma de pagamento: <xsl:value-of select="formaDePagamento" /></p>
		<xsl:apply-templates match="produtos" />
	</xsl:template>
	<xsl:template match="produtos">
		<xsl:apply-templates select="produto" />
	</xsl:template>
	<xsl:template match="produto">
		<h4><xsl:value-of select="nome" /></h4>
		<label>Preço:</label><span>R$ <xsl:value-of select="preco" /></span>
	</xsl:template>
</xsl:stylesheet>
