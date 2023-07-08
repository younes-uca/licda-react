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
                    label: 'Crud',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                                        {
                     label: 'Gender',
                     to: '/module/admin/view/rdv/gender-admin/list-admin/gender-list-admin.component'
                      },
                      {
                     label: 'Ville',
                     to: '/module/admin/view/rdv/ville-admin/list-admin/ville-list-admin.component'
                      },
                      {
                     label: 'Dose',
                     to: '/module/admin/view/rdv/dose-admin/list-admin/dose-list-admin.component'
                      },
                      {
                     label: 'EtatRendezVous',
                     to: '/module/admin/view/rdv/etat-rendez-vous-admin/list-admin/etat-rendez-vous-list-admin.component'
                      },
                      {
                     label: 'EtatDose',
                     to: '/module/admin/view/rdv/etat-dose-admin/list-admin/etat-dose-list-admin.component'
                      },
                      {
                     label: 'Patient',
                     to: '/module/admin/view/rdv/patient-admin/list-admin/patient-list-admin.component'
                      },
                      {
                     label: 'Quartier',
                     to: '/module/admin/view/rdv/quartier-admin/list-admin/quartier-list-admin.component'
                      },
                      {
                     label: 'Medecin',
                     to: '/module/admin/view/rdv/medecin-admin/list-admin/medecin-list-admin.component'
                      },
                      {
                     label: 'Center',
                     to: '/module/admin/view/rdv/center-admin/list-admin/center-list-admin.component'
                      },
                      {
                     label: 'EffetIndesirable',
                     to: '/module/admin/view/rdv/effet-indesirable-admin/list-admin/effet-indesirable-list-admin.component'
                      },
                      {
                     label: 'RendezVous',
                     to: '/module/admin/view/rdv/rendez-vous-admin/list-admin/rendez-vous-list-admin.component'
                      },
                      {
                     label: 'CategorieRdv',
                     to: '/module/admin/view/rdv/categorie-rdv-admin/list-admin/categorie-rdv-list-admin.component'
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
