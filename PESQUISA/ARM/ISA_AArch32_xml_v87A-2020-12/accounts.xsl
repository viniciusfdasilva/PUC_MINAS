<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

<xsl:output doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
 doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
 method="html" encoding="utf-8"/>

<xsl:template match="/accounts">
  <html>

    <head>
      <link rel="stylesheet" type="text/css" href="insn.css"/>
      <meta name="generator" content="encodingindex.xsl"/>
      <title>Tabulated Instruction field options</title>
    </head>

    <body>
    <table align="center">
      <tr>
        <!-- autogenerator: header/footer start -->
        <!-- autogenerated -->
	<td><div class="topbar"><a href="index.xml">Base Instructions</a></div></td>
	<td><div class="topbar"><a href="fpsimdindex.xml">SIMD&amp;FP Instructions</a></div></td>
	<td><div class="topbar"><a href="a32_encindex.xml">A32 Instructions by Encoding</a></div></td>
	<td><div class="topbar"><a href="t32_encindex.xml">T32 Instructions by Encoding</a></div></td>
	<td><div class="topbar"><a href="shared_pseudocode.xml">Shared Pseudocode</a></div></td>
	<td><div class="topbar"><a href="notice.xml">Proprietary Notice</a></div></td>
        <!-- autogenerator: header/footer end -->
      </tr>
    </table>  
    <hr/>
    <xsl:apply-templates/>
    <hr/>
    <table align="center">
      <tr>
        <!-- autogenerator: header/footer start -->
        <!-- autogenerated -->
	<td><div class="topbar"><a href="index.xml">Base Instructions</a></div></td>
	<td><div class="topbar"><a href="fpsimdindex.xml">SIMD&amp;FP Instructions</a></div></td>
	<td><div class="topbar"><a href="a32_encindex.xml">A32 Instructions by Encoding</a></div></td>
	<td><div class="topbar"><a href="t32_encindex.xml">T32 Instructions by Encoding</a></div></td>
	<td><div class="topbar"><a href="shared_pseudocode.xml">Shared Pseudocode</a></div></td>
	<td><div class="topbar"><a href="notice.xml">Proprietary Notice</a></div></td>
        <!-- autogenerator: header/footer end -->
      </tr>
    </table>  
    <!-- version footer -->
    <p class="versions">
        Internal version only: isa v01_24, pseudocode v2020-12, sve v2020-12-3-g87778bb      
        ; Build timestamp: 2020-12-17T15:20
    </p>
    <p class="copyconf">
      Copyright &#169; 2010-2015 Arm Limited or its affiliates. All rights reserved.
      This document is Non-Confidential.
    </p>
    </body>

    </html>
  </xsl:template>

  <xsl:template match="account">
    <h2>
      <xsl:value-of select="@iclass_long"/>
      <xsl:value-of select="@symbol"/>
    </h2>
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="account/orig">
    <p class="accounts-orig">
      <strong>Original text</strong>: <xsl:value-of select="."/>
    </p>
  </xsl:template>

  <xsl:template match="account/definition">
    <div class="explanations">
      <h4 class="encoding">Where:</h4>
      <table>
        <col class="asyn-l" />
        <col class="asyn-r" />
        <tr>
          <td>
            <xsl:value-of select="../@symbol"/>
          </td>
          <td>
            <xsl:apply-templates/>
          </td>
        </tr>
      </table>
    </div>
  </xsl:template>

  <xsl:template match="definition/intro">
    <xsl:value-of select="."/>
    encoded in 
    <xsl:choose>
      <xsl:when test="../@tabulatedwith">
        <q><xsl:value-of select="../@encodedin"/></q>, based on
        <q><xsl:value-of select="../@tabulatedwith"/></q>:
      </xsl:when>
      <xsl:otherwise>
        <q><xsl:value-of select="../@encodedin"/></q>:
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template match="definition/after">
    <xsl:value-of select="."/>
  </xsl:template>

  <xsl:template match="table">
    <table class="{@class}">
      <xsl:apply-templates/>
    </table>
  </xsl:template>

  <xsl:template match="thead">
    <thead>
      <xsl:apply-templates/>
    </thead>
  </xsl:template>

  <xsl:template match="row">
    <tr>
      <xsl:apply-templates/>
    </tr>
  </xsl:template>

  <xsl:template match="thead/row/entry">
    <th class="{@class}">
      <xsl:apply-templates/>
    </th>
  </xsl:template>

  <xsl:template match="tbody">
    <tbody>
      <xsl:apply-templates/>
    </tbody>
  </xsl:template>

  <xsl:template match="tbody/row/entry">
    <td class="{@class}">
      <xsl:apply-templates/>
    </td>
  </xsl:template>

</xsl:stylesheet>
