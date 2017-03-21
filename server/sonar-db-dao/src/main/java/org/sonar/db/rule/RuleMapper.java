/*
 * SonarQube
 * Copyright (C) 2009-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.db.rule;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.rules.RuleQuery;

public interface RuleMapper {

  List<RuleDto> selectAll();

  void selectEnabled(ResultHandler resultHandler);

  RuleDto selectById(long id);

  List<RuleDto> selectByIds(@Param("ids") List<Integer> ids);

  RuleDto selectByKey(RuleKey ruleKey);

  RuleDefinitionDto selectDefinitionByKey(RuleKey ruleKey);

  List<RuleDto> selectByKeys(@Param("ruleKeys") List<RuleKey> keys);

  List<RuleDto> selectByQuery(@Param("query") RuleQuery ruleQuery);

  void insert(RuleDefinitionDto ruleDefinitionDto);

  void updateDefinition(RuleDefinitionDto ruleDefinitionDto);

  void updateMetadata(RuleMetadataDto ruleMetadataDto);

  List<RuleParamDto> selectParamsByRuleIds(@Param("ruleIds") List<Integer> ruleIds);

  List<RuleParamDto> selectParamsByRuleKey(RuleKey ruleKey);

  List<RuleParamDto> selectParamsByRuleKeys(@Param("ruleKeys") List<RuleKey> ruleKeys);

  void insertParameter(RuleParamDto param);

  void updateParameter(RuleParamDto param);

  void deleteParameter(Integer paramId);
}