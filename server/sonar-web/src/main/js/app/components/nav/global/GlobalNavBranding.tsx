/*
 * SonarQube
 * Copyright (C) 2009-2018 SonarSource SA
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
import * as React from 'react';
import { Link } from 'react-router';
import { connect } from 'react-redux';
import { getGlobalSettingValue } from '../../../../store/rootReducer';
import { translate } from '../../../../helpers/l10n';
import { getBaseUrl } from '../../../../helpers/urls';

interface StateProps {
  customLogoUrl?: string;
  customLogoWidth?: string | number;
}

export function GlobalNavBranding({ customLogoUrl, customLogoWidth }: StateProps) {
  const title = translate('layout.sonar.slogan');
  const url = customLogoUrl || `${getBaseUrl()}/images/logo.svg?v=6.6`;
  const width = customLogoUrl ? customLogoWidth || 100 : 83;

  return (
    <div className="pull-left">
      <Link className="navbar-brand" to="/">
        <img alt={title} height={30} src={url} title={title} width={width} />
      </Link>
    </div>
  );
}

export function SonarCloudNavBranding() {
  return (
    <GlobalNavBranding
      customLogoUrl={`${getBaseUrl()}/images/sonarcloud-logo.svg`}
      customLogoWidth={105}
    />
  );
}

const mapStateToProps = (state: any): StateProps => ({
  customLogoUrl: (getGlobalSettingValue(state, 'sonar.lf.logoUrl') || {}).value,
  customLogoWidth: (getGlobalSettingValue(state, 'sonar.lf.logoWidthPx') || {}).value
});

export default connect<StateProps>(mapStateToProps)(GlobalNavBranding);