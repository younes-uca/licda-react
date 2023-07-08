import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import 'primereact/resources/themes/saga-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {FileUpload} from 'primereact/fileupload';
import {InputText} from 'primereact/inputtext';
import {Toast} from 'primereact/toast';
import {Toolbar} from 'primereact/toolbar';
import React, {useEffect, useRef, useState} from 'react';
import { Paginator } from 'primereact/paginator';
import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';
import {MessageService} from '/pages/controller/service/MessageService';
import {Card} from "primereact/card";
import {Calendar} from "primereact/calendar";
import {InputNumber} from "primereact/inputnumber";
import {Dropdown} from "primereact/dropdown";
import {AxiosResponse} from "axios";

import {RendezVousService} from '/pages/controller/service/RendezVous.service';
import {RendezVousDto}  from '/pages/controller/model/RendezVous.model';
import {RendezVousCriteria} from "/pages/controller/criteria/RendezVousCriteria.model";

import {EtatDoseDto} from '/pages/controller/model/EtatDose.model';
import {EtatDoseService} from '/pages/controller/service/EtatDose.service';
import {EffetIndesirableDto} from '/pages/controller/model/EffetIndesirable.model';
import {EffetIndesirableService} from '/pages/controller/service/EffetIndesirable.service';
import {CategorieRdvDto} from '/pages/controller/model/CategorieRdv.model';
import {CategorieRdvService} from '/pages/controller/service/CategorieRdv.service';
import {EtatRendezVousDto} from '/pages/controller/model/EtatRendezVous.model';
import {EtatRendezVousService} from '/pages/controller/service/EtatRendezVous.service';
import {CenterDto} from '/pages/controller/model/Center.model';
import {CenterService} from '/pages/controller/service/Center.service';
import {MedecinDto} from '/pages/controller/model/Medecin.model';
import {MedecinService} from '/pages/controller/service/Medecin.service';
import {PatientDto} from '/pages/controller/model/Patient.model';
import {PatientService} from '/pages/controller/service/Patient.service';
import {DoseDto} from '/pages/controller/model/Dose.model';
import {DoseService} from '/pages/controller/service/Dose.service';

import Edit from '/pages/module/admin/view/rdv/rendez-vous-admin/edit-admin/rendez-vous-edit-admin.component';
import Create from '/pages/module/admin/view/rdv/rendez-vous-admin/create-admin/rendez-vous-create-admin.component';
import View from '/pages/module/admin/view/rdv/rendez-vous-admin/view-admin/rendez-vous-view-admin.component';

const List = () => {

    const emptyItem = new RendezVousDto();
    const [items, setItems] = useState<RendezVousDto[]>([]);
    const [deleteItemDialog, setDeleteItemDialog] = useState(false);
    const [deleteItemsDialog, setDeleteItemsDialog] = useState(false);
    const [item, setItem] = useState<RendezVousDto>(emptyItem);
    const [selectedItems, setSelectedItems] = useState<RendezVousDto[]>([]);
    const [globalFilter, setGlobalFilter] = useState('');
    const [showCreateDialog, setShowCreateDialog] = useState<boolean>(false);
    const [showEditDialog, setShowEditDialog] = useState<boolean>(false);
    const [showViewDialog, setShowViewDialog] = useState<boolean>(false);
    const [selectedItem, setSelectedItem] = useState<RendezVousDto | null>(null);
    const [rows, setRows] = useState<number>(10);
    const [totalRecords, setTotalRecords] = useState(0);
    const [criteria, setCriteria] = useState(new RendezVousCriteria());
    const [first, setFirst] = useState(0);
    const toast = useRef<Toast>();
    const dt = useRef<DataTable<RendezVousDto[]>>();
    const [findByCriteriaShow, setFindByCriteriaShow] = useState(false);
    const [isSearchTriggered, setIsSearchTriggered] = useState(false);

    const [etatDoses, setEtatDoses] = useState<EtatDoseDto[]>([]);
    type EtatDoseResponse = AxiosResponse<EtatDoseDto[]>;
    const [effetIndesirables, setEffetIndesirables] = useState<EffetIndesirableDto[]>([]);
    type EffetIndesirableResponse = AxiosResponse<EffetIndesirableDto[]>;
    const [categorieRdvs, setCategorieRdvs] = useState<CategorieRdvDto[]>([]);
    type CategorieRdvResponse = AxiosResponse<CategorieRdvDto[]>;
    const [etatRendezVouss, setEtatRendezVouss] = useState<EtatRendezVousDto[]>([]);
    type EtatRendezVousResponse = AxiosResponse<EtatRendezVousDto[]>;
    const [centers, setCenters] = useState<CenterDto[]>([]);
    type CenterResponse = AxiosResponse<CenterDto[]>;
    const [medecins, setMedecins] = useState<MedecinDto[]>([]);
    type MedecinResponse = AxiosResponse<MedecinDto[]>;
    const [patients, setPatients] = useState<PatientDto[]>([]);
    type PatientResponse = AxiosResponse<PatientDto[]>;
    const [doses, setDoses] = useState<DoseDto[]>([]);
    type DoseResponse = AxiosResponse<DoseDto[]>;

    const showSearch = () => { setFindByCriteriaShow(!findByCriteriaShow); };

    const handleValidateClick = () => {setIsSearchTriggered(true);};

    const handleCancelClick = () => {
        setCriteria(new RendezVousCriteria());
        setIsSearchTriggered(true);
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [medecinsResponse ,categorieRdvsResponse ,patientsResponse ,etatDosesResponse ,etatRendezVoussResponse ,centersResponse ] = await Promise.all<MedecinResponse,CategorieRdvResponse,PatientResponse,EtatDoseResponse,EtatRendezVousResponse,CenterResponse>([
                    MedecinService.getList(),
                    CategorieRdvService.getList(),
                    PatientService.getList(),
                    EtatDoseService.getList(),
                    EtatRendezVousService.getList(),
                    CenterService.getList(),
                ]);
                setMedecins(medecinsResponse.data);
                setCategorieRdvs(categorieRdvsResponse.data);
                setPatients(patientsResponse.data);
                setEtatDoses(etatDosesResponse.data);
                setEtatRendezVouss(etatRendezVoussResponse.data);
                setCenters(centersResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
        if (isSearchTriggered) {
            fetchItems(criteria);
            setIsSearchTriggered(false);
        }
        fetchData();
        fetchItems(criteria);
    }, [isSearchTriggered]);

    const fetchItems = async (criteria) => {
        try {
            const response = await RendezVousService.findPaginatedByCriteria(criteria);
            const paginatedItems = response.data;
            setTotalRecords(paginatedItems.dataSize);
            setItems(paginatedItems.list);
        } catch (error) {
            console.log(error);
        }
    };

    const onPage = (event) => {
        const updatedCriteria = { ...criteria, page: event.page,maxResults: event.rows };
        setCriteria(updatedCriteria);
        setFirst(event.first);
        fetchItems(updatedCriteria);
    };

    const showCreateModal = (): void => {
        setShowCreateDialog(true);
    };

    const showEditModal = (item: RendezVousDto) => {
        setSelectedItem(item);
        setShowEditDialog(true);
    };

    const showViewModal = (item: RendezVousDto) => {
        setSelectedItem(item);
        setShowViewDialog(true);
    };

    const add = (item) => {
        setItems([...items, item]);
    };

    const update = (updatedItem: RendezVousDto) => {
        const updatedList = items.map((item) => {
            if (item.id === updatedItem.id) { return updatedItem; }
            return item;
        });
        setItems(updatedList);
    };

   const hideDeleteItemDialog = () => {
        setDeleteItemDialog(false);
   };

   const hideDeleteItemsDialog = () => {
        setDeleteItemsDialog(false);
   };

    const confirmDeleteItem = (item: RendezVousDto) => {
        setSelectedItem(item);
        setDeleteItemDialog(true);
    };

    const deleteItem = async () => {
        try{
            await RendezVousService.delete(selectedItem?.id);
            setDeleteItemDialog(false);
            setItem(emptyItem);
            let _items = items.filter((val) => val.id !== selectedItem?.id);
            setItems(_items);
            MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'RendezVous Deleted', life: 3000 });
        } catch (error) {
            console.log(error);
        }
    };

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteItemsDialog(true);
    };

    const deleteSelectedItems = async () => {
        await RendezVousService.deleteList(selectedItems);
        let _items = items.filter((val) => !selectedItems.includes(val));
        setItems(_items);
        setDeleteItemsDialog(false);
        setSelectedItems(null);
        MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'RendezVouss Deleted', life: 3000 });
    };

   const leftToolbarTemplate = () => {
       return (
           <React.Fragment>
               <div className="my-2">
                   <Button label="New" icon="pi pi-plus" severity="success" className=" mr-2" onClick={ showCreateModal} />
                   <Button label="Delete" icon="pi pi-trash" severity="danger" className=" mr-2" onClick={confirmDeleteSelected} disabled={!selectedItems || !selectedItems.length} />
                   <Button label="Search" icon={`pi pi-${findByCriteriaShow ? 'angle-down' : 'angle-right'}`} className=" mr-2" severity="warning" onClick={showSearch} />
               </div>
           </React.Fragment>
       );
   };

   const rightToolbarTemplate = () => {
       return (
           <React.Fragment>
               <FileUpload mode="basic" accept="image/*" maxFileSize={1000000} chooseLabel="Import" className="mr-2 inline-block" />
               <Button label="Export" icon="pi pi-upload" severity="help" onClick={exportCSV} />
           </React.Fragment>
       );
   };

    const actionBodyTemplate = (rowData: PurchaseDto) => {
       return ( <>
           <Button icon="pi pi-pencil" rounded severity="success" className="mr-1" onClick={() => showEditModal(rowData)} />
           <Button icon="pi pi-trash" rounded  severity="danger" className="mr-1"  onClick={() => confirmDeleteItem(rowData)} />
           <Button icon="pi pi-eye" rounded severity="info" className="mr-1" onClick={() => showViewModal(rowData)} /> < />
       );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
        <h5 className="m-0">Manage RendezVouss</h5>
        <span className="block mt-2 md:mt-0 p-input-icon-left"><i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)} placeholder="Search..." /> </span>
        </div>
    );

    const deleteItemDialogFooter = ( <>
        <Button label="No" icon="pi pi-times" text onClick={hideDeleteItemDialog} />
        <Button label="Yes" icon="pi pi-check" text onClick={deleteItem} /> < />
    );

    const deleteItemsDialogFooter = ( <>
        <Button label="No" icon="pi pi-times" text onClick={hideDeleteItemsDialog} />
        <Button label="Yes" icon="pi pi-check" text onClick={deleteSelectedItems} /> < />
    );

return (
    <div className="grid crud-demo">
        <div className="col-12">
            <div className="card">
                <Toast ref={toast} />
                <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>
                {findByCriteriaShow && (
                <Card>
                    <div className="search-container">
                        <div className="grid">
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Dropdown id="1" value={criteria.patient} options={patients} onChange={(e) => setCriteria({ ...criteria, patient: e.target.value })} optionLabel="email" filter showClear placeholder="Patient" />
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Dropdown id="2" value={criteria.center} options={centers} onChange={(e) => setCriteria({ ...criteria, center: e.target.value })} optionLabel="libelle" filter showClear placeholder="Center" />
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Dropdown id="3" value={criteria.medecin} options={medecins} onChange={(e) => setCriteria({ ...criteria, medecin: e.target.value })} optionLabel="email" filter showClear placeholder="Medecin" />
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Calendar id="4-1" value={criteria.datePriseRdvFrom} onChange={(e) => setCriteria({ ...criteria, datePriseRdvFrom: e.value as Date })} dateFormat="dd-MM-yy" />
                                        <label htmlFor="4-1">DatePriseRdv Min</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Calendar id="4-2" value={criteria.datePriseRdvTo} onChange={(e) => setCriteria({ ...criteria, datePriseRdvTo: e.value as Date })} dateFormat="dd-MM-yy" />
                                        <label htmlFor="4-2">DatePriseRdv Max</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Dropdown id="5" value={criteria.categorieRdv} options={categorieRdvs} onChange={(e) => setCriteria({ ...criteria, categorieRdv: e.target.value })} optionLabel="libelle" filter showClear placeholder="CategorieRdv" />
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Dropdown id="6" value={criteria.etatRendezVous} options={etatRendezVouss} onChange={(e) => setCriteria({ ...criteria, etatRendezVous: e.target.value })} optionLabel="libelle" filter showClear placeholder="EtatRendezVous" />
                                        </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label="Validate" icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label="Cancel" className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                    </div>
                        </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as RendezVousDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="patient.email" header="Patient" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="center.libelle" header="Center" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="medecin.email" header="Medecin" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="datePriseRdv" header="DatePriseRdv" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="categorieRdv.libelle" header="CategorieRdv" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="etatRendezVous.libelle" header="EtatRendezVous" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    <Column header="Actions" body={actionBodyTemplate} headerStyle={{minWidth: '10rem'}}></Column>
                </DataTable>
                <div className="p-d-flex p-ai-center p-jc-between">
                    <Paginator onPageChange={onPage} first={first} rows={rows} totalRecords={totalRecords} />
                </div>
                <Create visible={showCreateDialog} onClose={() => setShowCreateDialog(false)} add={add} showToast={toast} list={items} />
                <Edit  visible={showEditDialog} onClose={() =>  { setShowEditDialog(false); setSelectedItem(null); }} showToast={toast} selectedItem={selectedItem} update={update} />
                <View visible={showViewDialog} onClose={() =>  { setShowViewDialog(false); setSelectedItem(null); }} selectedItem={selectedItem} />
                <Dialog visible={deleteItemDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemDialogFooter} onHide={hideDeleteItemDialog}>
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}}/>
                    {item && (<span>Are you sure you want to delete rendez vous <b>{item.id}</b>?</span>)}
                    </div>
                </Dialog>
                <Dialog visible={deleteItemsDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemsDialogFooter} onHide={hideDeleteItemsDialog} >
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}} />
                    {item && <span>Are you sure you want to delete the selected rendez vouss?</span>}
                    </div>
                </Dialog>
            </div>
        </div>
    </div>
);
};
export default List;

