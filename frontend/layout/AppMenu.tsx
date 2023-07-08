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
                     label: 'Dose',
                     to: '/module/admin/view/rdv/dose-admin/list-admin/dose-list-admin.component'
                      },
                      {
                     label: 'CategorieRdv',
                     to: '/module/admin/view/commun/categorieRdv-admin/list-admin/categorieRdv-list-admin.component'
                      },
                      {
                     label: 'EtatRendezVous',
                     to: '/module/admin/view/commun/etatRendezVous-admin/list-admin/etatRendezVous-list-admin.component'
                      },
                      {
                     label: 'Medecin',
                     to: '/module/admin/view/actor/medecin-admin/list-admin/medecin-list-admin.component'
                      },
                      {
                     label: 'Gender',
                     to: '/module/admin/view/commun/gender-admin/list-admin/gender-list-admin.component'
                      },
                      {
                     label: 'Center',
                     to: '/module/admin/view/commun/center-admin/list-admin/center-list-admin.component'
                      },
                      {
                     label: 'EffetIndesirable',
                     to: '/module/admin/view/rdv/effetIndesirable-admin/list-admin/effetIndesirable-list-admin.component'
                      },
                      {
                     label: 'RendezVous',
                     to: '/module/admin/view/rdv/rendezVous-admin/list-admin/rendezVous-list-admin.component'
                      },
                      {
                     label: 'Patient',
                     to: '/module/admin/view/actor/patient-admin/list-admin/patient-list-admin.component'
                      },
                      {
                     label: 'EtatDose',
                     to: '/module/admin/view/commun/etatDose-admin/list-admin/etatDose-list-admin.component'
                      },
                      {
                     label: 'Quartier',
                     to: '/module/admin/view/commun/quartier-admin/list-admin/quartier-list-admin.component'
                      },
                      {
                     label: 'Ville',
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
