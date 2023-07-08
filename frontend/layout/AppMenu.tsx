/* eslint-disable @next/next/no-img-element */

import React, {useContext} from 'react';
import AppMenuitem from '/layout/AppMenuitem';
import {LayoutContext} from '/layout/context/layoutcontext';
import {MenuProvider} from '/layout/context/menucontext';
import {AppMenuItem} from '/types/types';

const AppMenu = () => {
    const {layoutConfig} = useContext(LayoutContext);

    const model: AppMenuItem[] = [
        {
            label: 'Home',
            items: [{label: 'Dashboard', icon: 'pi pi-fw pi-home', to: '/dashboard'}]
        },


        {
            label: 'Pages',
            icon: 'pi pi-fw pi-briefcase',
            to: '/pages',
            items: [

                {
                    label: 'Auth',
                    icon: 'pi pi-fw pi-user',
                    items: [
                        {
                            label: 'Error',
                            icon: 'pi pi-fw pi-times-circle',
                            to: '/auth/error'
                        },
                        {
                            label: 'Access Denied',
                            icon: 'pi pi-fw pi-lock',
                            to: '/auth/access'
                        }
                    ]
                },
                {
                    label: 'Actor Management',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                        {
                            label: 'Liste medecin',
                            to: '/module/admin/view/actor/medecin-admin/list-admin/medecin-list-admin.component'
                        },
                        {
                            label: 'Liste patient',
                            to: '/module/admin/view/actor/patient-admin/list-admin/patient-list-admin.component'
                        },
                    ]
                },
                {
                    label: 'RDV Management',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                        {
                            label: 'Liste dose',
                            to: '/module/admin/view/rdv/dose-admin/list-admin/dose-list-admin.component'
                        },
                        {
                            label: 'Liste effet indesirable',
                            to: '/module/admin/view/rdv/effet-indesirable-admin/list-admin/effet-indesirable-list-admin.component'
                        },
                        {
                            label: 'Liste rendez vous',
                            to: '/module/admin/view/rdv/rendez-vous-admin/list-admin/rendez-vous-list-admin.component'
                        },
                    ]
                },
                {
                    label: 'Referentiel Management',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                      {
                      label: 'Liste categorie rdv',
                     to: '/module/admin/view/commun/categorie-rdv-admin/list-admin/categorie-rdv-list-admin.component'
                      },
                      {
                      label: 'Liste etat rendez vous',
                     to: '/module/admin/view/commun/etat-rendez-vous-admin/list-admin/etat-rendez-vous-list-admin.component'
                      },
                      {
                      label: 'Liste gender',
                     to: '/module/admin/view/commun/gender-admin/list-admin/gender-list-admin.component'
                      },
                      {
                      label: 'Liste center',
                     to: '/module/admin/view/commun/center-admin/list-admin/center-list-admin.component'
                      },
                      {
                      label: 'Liste etat dose',
                     to: '/module/admin/view/commun/etat-dose-admin/list-admin/etat-dose-list-admin.component'
                      },
                      {
                      label: 'Liste quartier',
                     to: '/module/admin/view/commun/quartier-admin/list-admin/quartier-list-admin.component'
                      },
                      {
                      label: 'Liste ville',
                     to: '/module/admin/view/commun/ville-admin/list-admin/ville-list-admin.component'
                      },
                    ]
                },
                {
                    label: 'Timeline',
                    icon: 'pi pi-fw pi-calendar',
                    to: '/pages/timeline'
                },
                {
                    label: 'Not Found',
                    icon: 'pi pi-fw pi-exclamation-circle',
                    to: '/pages/notfound'
                },
                {
                    label: 'Empty',
                    icon: 'pi pi-fw pi-circle-off',
                    to: '/pages/empty'
                }
            ]
        },

    ];

    return (
        <MenuProvider>
            <ul className="layout-menu">
                {model.map((item, i) => {
                    return !item?.seperator ? <AppMenuitem item={item} root={true} index={i} key={item.label}/> :
                        <li className="menu-separator"></li>;
                })}


            </ul>
        </MenuProvider>
    );
};


export default AppMenu;
