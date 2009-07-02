/*
 * Copyright (C) 2009 Inderjeet Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.java2objc.objc;

import japa.parser.ast.stmt.IfStmt;

public class ObjcIfStatement extends ObjcStatement {
  private final ObjcExpression condition;
  private final ObjcStatement thenStmt;
  private final ObjcStatement elseStmt;
  
  public ObjcIfStatement(IfStmt n) {
    super(n);
    this.condition = new ObjcExpression(n.getCondition());
    this.thenStmt = new ObjcStatement(n.getThenStmt());
    this.elseStmt = new ObjcStatement(n.getElseStmt());
  }

  @Override
  public void append(SourceCodeWriter writer) {
    writer.startLine().append("if (").append(condition).append(") {").endLine();
    writer.indent().appendLine(thenStmt).unIndent();
    writer.appendLine("} else {");
    writer.indent().appendLine(elseStmt).unIndent();
    writer.appendLine("}");
  }
}
